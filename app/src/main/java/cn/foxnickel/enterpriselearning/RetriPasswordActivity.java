package cn.foxnickel.enterpriselearning;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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
    private boolean isSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password);
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
        mBtVerify.setOnClickListener(this);
        btOk.setOnClickListener(this);
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
                    countDown();
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
        }
    }

    private void countDown() {
        final long count = 60;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count + 1)//take设置超过多少秒停止执行
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return count - aLong;
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mBtVerify.setEnabled(false);
                        mBtVerify.setTextColor(Color.BLACK);
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Long value) {
                mBtVerify.setText(value + "秒后重新开始");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                mBtVerify.setEnabled(true);
                mBtVerify.setText("发送验证码");
            }
        });
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

}
