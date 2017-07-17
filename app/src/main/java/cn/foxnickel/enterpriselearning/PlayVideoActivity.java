package cn.foxnickel.enterpriselearning;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.module.SwitchVideoModel;
import cn.foxnickel.enterpriselearning.utils.DisplayUtil;

/**
 * Created by Night on 2017/7/13.
 * Desc:
 */

public class PlayVideoActivity extends AppCompatActivity {
    private SampleVideo mVpPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        initView();

    }

    private void initView() {
        mVpPlayer = (SampleVideo) findViewById(R.id.vp_player);
        mVpPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setupVideo();
    }

    private void setupVideo() {
        String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        String name = "普通";
        SwitchVideoModel switchVideoModel = new SwitchVideoModel(name, source1);

        String source2 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4";
        String name2 = "清晰";
        SwitchVideoModel switchVideoModel2 = new SwitchVideoModel(name2, source2);

        List<SwitchVideoModel> list = new ArrayList<>();
        list.add(switchVideoModel);
        list.add(switchVideoModel2);

        mVpPlayer.setUp(list, true, "");

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.login_bg2);
        mVpPlayer.setThumbImageView(imageView);

        //增加title
        mVpPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        mVpPlayer.getTitleTextView().setText(getIntent().getStringExtra("title"));

        //设置返回键
        mVpPlayer.getBackButton().setVisibility(View.VISIBLE);
        mVpPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置全屏按键功能
        mVpPlayer.getFullscreenButton().setVisibility(View.GONE);


        mVpPlayer.setIsTouchWiget(true);
        //关闭自动旋转
        mVpPlayer.setRotateViewAuto(false);
        mVpPlayer.setLockLand(false);
        mVpPlayer.setShowFullAnimation(false);
        mVpPlayer.setNeedLockFull(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mVpPlayer.getBackButton().setVisibility(View.VISIBLE);
        mVpPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVpPlayer.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        });
        mVpPlayer.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //屏幕为横屏时
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dp2px(this, 240f));
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }

    private void setVideoViewScale(int w, int h) {
        ViewGroup.LayoutParams l = mVpPlayer.getLayoutParams();
        l.width = w;
        l.height = h;
        mVpPlayer.setLayoutParams(l);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
    }
}
