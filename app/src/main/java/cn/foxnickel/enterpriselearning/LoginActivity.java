package cn.foxnickel.enterpriselearning;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.config.Config;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtLogin;//登录按钮
    private ProgressBar mProgressView;//登录过程显示的Progressbar
    private ConstraintLayout mLoginFormView;//登录的主界面
    private AutoCompleteTextView mEtJobNumber;//员工账号
    private EditText mEtPassword;//密码
    private UserLoginTask mAuthTask = null;//异步登录验证的task
    private TextView mTvForgetPass;//忘记密码
    private CheckBox mCbRememberPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Config.sSp.getBoolean(Config.KEY_REMEMBER_PAS, false)) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        initView();
    }

    private void initView() {
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mProgressView = (ProgressBar) findViewById(R.id.login_progress);
        mLoginFormView = (ConstraintLayout) findViewById(R.id.login_form);
        mEtJobNumber = (AutoCompleteTextView) findViewById(R.id.et_phone_number);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        /*在密码框按回车键的监听事件*/
        mEtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        mTvForgetPass = (TextView) findViewById(R.id.tv_forget_pass);
        mTvForgetPass.setOnClickListener(this);
        mCbRememberPwd = (CheckBox) findViewById(R.id.cb_remember_pwd);
        mCbRememberPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                attemptLogin();
                break;
            case R.id.tv_forget_pass:
                startActivity(new Intent(this, RetriPasswordActivity.class));
                break;
        }
    }

    /**
     * 显示progressbar并隐藏登录布局
     *
     * @param show 是否显示
     */
    private void showProgress(final boolean show) {

        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    /**
     * 请求登录
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEtJobNumber.setError(null);
        mEtPassword.setError(null);

        // Store values at the time of the login attempt.
        String jobNumber = mEtJobNumber.getText().toString();
        String password = mEtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(password)) {
            mEtPassword.setError(getString(R.string.error_invalid_password));
            focusView = mEtPassword;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mEtPassword.setError(getString(R.string.error_invalid_password));
            focusView = mEtPassword;
            cancel = true;
        }


        if (TextUtils.isEmpty(jobNumber)) {
            mEtJobNumber.setError(getString(R.string.error_field_required));
            focusView = mEtJobNumber;
            cancel = true;
        } else if (!isNumberValid(jobNumber)) {
            mEtJobNumber.setError(getString(R.string.error_invalid_number));
            focusView = mEtJobNumber;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            showProgress(false);
            mAuthTask = new UserLoginTask(jobNumber, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isNumberValid(String jobNumber) {
        //TODO: Replace this with your own logic
        return jobNumber.length() == 6;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * 登录验证
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: 删除下面的sleep并 attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }


            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                SharedPreferences.Editor editor = Config.sSp.edit();
                editor.putBoolean(Config.KEY_REMEMBER_PAS, mCbRememberPwd.isChecked());
                editor.apply();
                editor.commit();
                finish();
                Intent startMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(startMainActivity);
            } else {
                mEtPassword.setError(getString(R.string.error_incorrect_password));
                mEtPassword.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
