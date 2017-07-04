package cn.foxnickel.enterpriselearning.config;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mob.MobApplication;

/**
 * Created by Night on 2017/7/4
 * Desc:全局设置
 */

public class Config extends MobApplication {
    public static final int WRITE_EXTERNAL_CODE = 0X01;
    public static SharedPreferences sSp;

    public static String KEY_REMEMBER_PAS = "KEY_REMEMBER_PAS";

    @Override
    public void onCreate() {
        super.onCreate();
        sSp = PreferenceManager.getDefaultSharedPreferences(this);

    }
}
