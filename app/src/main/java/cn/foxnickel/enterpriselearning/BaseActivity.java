package cn.foxnickel.enterpriselearning;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.config.Config;

/**
 * Created by Night on 2017/3/5.
 * Desc:权限申请
 */

public class BaseActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermission(Config.WRITE_EXTERNAL_CODE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS);
        }

    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestPermission(int code, String... permissions) {
        List<String> permissionList = new ArrayList<>();//要申请的权限列表
        /**
         * 判断权限是否已经拥有，若未拥有则添加到List中
         */
        for (String permission : permissions) {
            switch (checkSelfPermission(permission)) {
                case PackageManager.PERMISSION_GRANTED:
                    Log.i(TAG, "onCreate: Granted...");
                    break;
                case PackageManager.PERMISSION_DENIED:
                    Log.i(TAG, "onCreate: Denied...");
                    permissionList.add(permission);
                    break;
            }
        }
        //申请未拥有的权限
        if (!permissionList.isEmpty()) {
            requestPermissions(permissionList.toArray(new String[permissionList.size()]), code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Config.WRITE_EXTERNAL_CODE:
                break;
            default:
                break;
        }
    }


}