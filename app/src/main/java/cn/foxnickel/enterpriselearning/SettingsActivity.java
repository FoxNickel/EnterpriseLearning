package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import cn.foxnickel.enterpriselearning.config.Config;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Toolbar mToolbar;
    private View mUserInfo;
    private Button mBtSignOut;
    private Switch mSwiNotification;
    private Switch mSwiWifiOpen;

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
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
        mSwiNotification = (Switch) findViewById(R.id.swi_notification);
        mSwiNotification.setOnCheckedChangeListener(this);
        mSwiWifiOpen = (Switch) findViewById(R.id.swi_wifi_open);
        mSwiWifiOpen.setOnCheckedChangeListener(this);
        mSwiNotification.setChecked(Config.sSp.getBoolean(Config.KEY_NOTIFICATION, false));
        mSwiWifiOpen.setChecked(Config.sSp.getBoolean(Config.KEY_WIFI_OPEN, false));


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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.swi_notification:

                break;
            case R.id.swi_wifi_open:

                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = Config.sSp.edit();
        editor.putBoolean(Config.KEY_NOTIFICATION, mSwiNotification.isChecked());
        editor.putBoolean(Config.KEY_WIFI_OPEN, mSwiWifiOpen.isChecked());
        editor.apply();
        super.onBackPressed();
    }
}
