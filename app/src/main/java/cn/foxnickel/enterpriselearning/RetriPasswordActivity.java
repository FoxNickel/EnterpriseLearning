package cn.foxnickel.enterpriselearning;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static cn.foxnickel.enterpriselearning.R.id.et_password;
import static cn.foxnickel.enterpriselearning.R.id.et_repassword;

/**
 * Created by Night on 2017/7/3.
 * Desc:找回密码
 */

public class RetriPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private AutoCompleteTextView mEtPhoneNumber;
    private EditText mEtPassword;
    private EditText mEtRepassword;
    private AutoCompleteTextView mEtVerifyNumber;
    private Button mBtVerify;
    private EventHandler mEventHandler;
    private CountDownTime mTime;
    private boolean isSuccess = false;
    private Button mBtGetPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password);
        SMSSDK.setAskPermisionOnReadContact(true);
        initView();
        // 创建EventHandler对象
        mEventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        Log.e("TAG", "EVENT_SUBMIT_VERIFICATION_CODE");
                        isSuccess = true;
                        //提交验证码成功
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {

                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }


        };
        // 注册监听器
        SMSSDK.registerEventHandler(mEventHandler);
    }

    private void initView() {
        mEtPhoneNumber = (AutoCompleteTextView) findViewById(R.id.et_phone_number);
        mEtPassword = (EditText) findViewById(et_password);
        mEtRepassword = (EditText) findViewById(et_repassword);
        mEtVerifyNumber = (AutoCompleteTextView) findViewById(R.id.et_verify_number);
        mBtVerify = (Button) findViewById(R.id.bt_verify);
        Button btOk = (Button) findViewById(R.id.bt_ok);
        mTime = new CountDownTime(60000, 1000);
        mBtVerify.setOnClickListener(this);
        btOk.setOnClickListener(this);
        mBtGetPhoneNumber = (Button) findViewById(R.id.bt_get_phone_number);
        mBtGetPhoneNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userPhone = mEtPhoneNumber.getText().toString().trim();
        String pass = mEtPassword.getText().toString().trim();
        String repass = mEtRepassword.getText().toString().trim();
        String verify = mEtVerifyNumber.getText().toString().trim();
        switch (v.getId()) {
            case R.id.bt_verify:
                if (isMobileNO(userPhone) &&
                        isPassword(pass, repass)) {
                    mTime.start();
                    SMSSDK.getVerificationCode("86", userPhone);
                    isSuccess = false;
                }
                break;
            case R.id.bt_ok:
                if (!TextUtils.isEmpty(userPhone) && !TextUtils.isEmpty(pass)) {
                    if (TextUtils.isEmpty(verify)) {
                        mEtVerifyNumber.setError("请输入验证码");
                        break;
                    }
                    SMSSDK.submitVerificationCode("86", userPhone, verify);
                    if (isSuccess) {
                        Toast.makeText(this, "找回密码成功", Toast.LENGTH_SHORT).show();
                    } else {
                        mEtVerifyNumber.setError("验证码错误");
                    }
                } else {
                    Toast.makeText(RetriPasswordActivity.this, "请输入手机号和密码", Toast.LENGTH_SHORT).show();
                }
                isSuccess = false;
                break;
            case R.id.bt_get_phone_number:
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                Intent intent = new Intent(Intent.ACTION_PICK,
                        uri);
                startActivityForResult(intent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                if (data == null) {
                    return;
                }
//处理返回的data,获取选择的联系人信息
                Uri uri = data.getData();
                String contacts = getPhoneContacts(uri);
                String[] phonenum = contacts.split("\\+86", 2);
                if (phonenum.length < 2) {
                    mEtPhoneNumber.setText(phonenum[0]);
                } else {
                    mEtPhoneNumber.setText(phonenum[1]);
                }

                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getPhoneContacts(Uri uri) {
        String contact = "";
//得到ContentResolver对象
        ContentResolver cr = getContentResolver();
//取得电话本中开始一项的光标
        Cursor cursor = cr.query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
            if (phone != null) {
                phone.moveToFirst();
                contact = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            phone.close();
            cursor.close();
        } else {
            return null;
        }
        return contact;
    }


    public boolean isMobileNO(String mobiles) {
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            mEtPhoneNumber.setError("请输入手机号");
            mEtPhoneNumber.requestFocus();
            return false;
        } else {
            if (!mobiles.matches(telRegex)) {
                mEtPhoneNumber.setError("您输入的手机号有误，请重新输入");
                mEtPhoneNumber.requestFocus();
                mEtPhoneNumber.setText("");
                return false;
            } else return true;
        }
    }

    private boolean isPassword(String password, String repassword) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
        if (TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword)) {
            mEtPassword.setError("请输入密码");
            mEtPassword.requestFocus();
            return false;
        } else if (!mEtPassword.getText().toString().trim().equals(mEtRepassword.getText().toString().trim())) {
            mEtPassword.setError("两次输入的密码不一致");
            mEtPassword.requestFocus();
            mEtPassword.setText("");
            mEtRepassword.setText("");
            return false;
        } else {
            if (!password.matches(regex)) {
                mEtPassword.setError("密码应在8-16位之间，必须包含至少一位大写字母、小写字母，数字");
                mEtPassword.requestFocus();
                mEtPassword.setText("");
                mEtRepassword.setText("");
                return false;
            } else
                return true;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mEventHandler);
    }

    private class CountDownTime extends CountDownTimer {

        //构造函数  第一个参数代表总的计时时长  第二个参数代表计时间隔  单位都是毫秒
        CountDownTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) { //每计时一次回调一次该方法
            mBtVerify.setClickable(false);
            mBtVerify.setText(l / 1000 + "秒后重新开始");
        }

        @Override
        public void onFinish() { //计时结束回调该方法
            mBtVerify.setClickable(true);
            mBtVerify.setText(R.string.verify);
        }
    }

}
