package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import cn.foxnickel.enterpriselearning.config.Config;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private View mUserInfo;
    private Button mBtSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();
    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mUserInfo = findViewById(R.id.layout_user_info);
        mUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, UserInfoActivity.class));
            }
        });

        mBtSignOut = (Button) findViewById(R.id.bt_sign_out);
        mBtSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sign_out:
                finish();
                SharedPreferences.Editor editor = Config.sSp.edit();
                editor.putBoolean(Config.KEY_REMEMBER_PAS, false);
                editor.apply();
                startActivity(new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                break;
        }
    }

}
