package cn.foxnickel.enterpriselearning.config;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itheima.retrofitutils.ItheimaHttp;
import com.mob.MobApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.foxnickel.enterpriselearning.bean.DaoMaster;
import cn.foxnickel.enterpriselearning.bean.DaoSession;

/**
 * Created by Night on 2017/7/4
 * Desc:全局设置
 */

public class Config extends MobApplication {
    public static final int WRITE_EXTERNAL_CODE = 0X01;
    public static SharedPreferences sSp;

    public static String KEY_REMEMBER_PAS = "KEY_REMEMBER_PAS";
    public static String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    public static String KEY_WIFI_OPEN = "KEY_WIFI_OPEN";

    public static ExecutorService fixedThreadPool;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
        sSp = PreferenceManager.getDefaultSharedPreferences(this);
        fixedThreadPool = Executors.newFixedThreadPool(5);
        ItheimaHttp.init(this, " http://www.oschina.net");
    }

    public static int getTextViewHeight(TextView pTextView) {
        Layout layout = pTextView.getLayout();
        int desired = layout.getLineTop(pTextView.getLineCount());
        int padding = pTextView.getCompoundPaddingTop() + pTextView.getCompoundPaddingBottom();
        return desired + padding;
    }

    /**
     * 保存List
     *
     * @param tag
     * @param datalist
     */
    public static <T> void setDataList(String tag, List<T> datalist) {
        SharedPreferences.Editor editor = sSp.edit();
        if (null == datalist || datalist.size() <= 0)
            return;

        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);
        editor.putString(tag, strJson);
        editor.apply();
    }

    /**
     * 获取List
     *
     * @param tag
     * @return
     */
    public static <T> void getDataList(List<T> datalist, String tag) {
        String strJson = Config.sSp.getString(tag, null);
        if (null == strJson) {
            Log.e("TAG", "null");
            datalist = new ArrayList<>();
            return;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {
        }.getType());
    }

    private static DaoSession daoSession;

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
