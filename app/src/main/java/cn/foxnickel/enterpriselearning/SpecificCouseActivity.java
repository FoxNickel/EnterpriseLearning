package cn.foxnickel.enterpriselearning;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.xlhratingbar_lib.XLHRatingBar;
import com.github.clans.fab.FloatingActionButton;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.SpecificCoursePagerAdapter;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCChaptersFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCDetailsFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCNoteFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCQAFragment;
import cn.foxnickel.enterpriselearning.module.SwitchVideoModel;
import cn.foxnickel.enterpriselearning.utils.DisplayUtil;
import cn.foxnickel.enterpriselearning.utils.ScreenUtil;

import static com.mob.MobSDK.getContext;

/**
 * Created by Night on 2017/7/8.
 * Desc:
 */

public class SpecificCouseActivity extends AppCompatActivity implements View.OnClickListener {

    public static SampleVideo mVpPlayer;
    private TabLayout mTabLayout;
    private ViewPager mViewPagerCourse;
    private OrientationUtils orientationUtils;
    private boolean isFullScreen = false;
    private ConstraintLayout mVideoLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mFabNote, mFabComment, mFabCollect;
    //popupwindow组件
    private LayoutInflater mLayoutInflater;
    View popupView;
    PopupWindow popupWindow;
    private EditText mEtComment;
    private Button mBtRelease;
    private XLHRatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_course);
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

        mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = mLayoutInflater.inflate(R.layout.popupwindow_course_score, null);
        mEtComment = (EditText) popupView.findViewById(R.id.et_comment);
        mBtRelease = (Button) popupView.findViewById(R.id.bt_release);
        mBtRelease.setOnClickListener(this);
        mRatingBar = (XLHRatingBar) popupView.findViewById(R.id.ratingBar);
        int density = (int) ScreenUtil.getDeviceDensity(this);
        popupWindow = new PopupWindow(popupView, 300 * density, 280 * density);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        mVpPlayer = (SampleVideo) findViewById(R.id.vp_player);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mVideoLayout = (ConstraintLayout) findViewById(R.id.cl_specific_course);
        mViewPagerCourse = (ViewPager) findViewById(R.id.view_pager_course);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(SCChaptersFragment.newInstance());
        fragmentList.add(SCDetailsFragment.newInstance());
        fragmentList.add(SCQAFragment.newInstance());
        fragmentList.add(SCNoteFragment.newInstance());
        SpecificCoursePagerAdapter specificCoursePagerAdapter = new SpecificCoursePagerAdapter(getSupportFragmentManager(), fragmentList, getContext());
        mViewPagerCourse.setAdapter(specificCoursePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPagerCourse);
        mVpPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setupVideo();

        mFabNote = (FloatingActionButton) findViewById(R.id.fab_note);
        mFabComment = (FloatingActionButton) findViewById(R.id.fab_comment);
        mFabCollect = (FloatingActionButton) findViewById(R.id.fab_collect);
        mFabNote.setOnClickListener(this);
        mFabComment.setOnClickListener(this);
        mFabCollect.setOnClickListener(this);
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
        mVpPlayer.getTitleTextView().setText("测试视频");

        //设置返回键
        mVpPlayer.getBackButton().setVisibility(View.GONE);
        mVpPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                isFullScreen = false;
                mVpPlayer.getBackButton().setVisibility(View.GONE);
            }
        });
        //设置旋转
        orientationUtils = new OrientationUtils(this, mVpPlayer);

        //设置全屏按键功能
        mVpPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
            }
        });


        mVpPlayer.setIsTouchWiget(true);
        //关闭自动旋转
        mVpPlayer.setRotateViewAuto(false);
        mVpPlayer.setLockLand(false);
        mVpPlayer.setShowFullAnimation(false);
        mVpPlayer.setNeedLockFull(true);
        mVpPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFullScreen) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    isFullScreen = false;
                    mVpPlayer.getBackButton().setVisibility(View.GONE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    isFullScreen = true;
                    mVpPlayer.getBackButton().setVisibility(View.VISIBLE);
                }
            }
        });

    }

    /**
     * 监听屏幕变换
     *
     * @param newConfig
     **/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //屏幕为横屏时
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            isFullScreen = true;
            mToolbar.setVisibility(View.GONE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dp2px(this, 240f));
            isFullScreen = false;
            mToolbar.setVisibility(View.VISIBLE);
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

    @Override
    public void onBackPressed() {
        if (isFullScreen) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            isFullScreen = false;
            mVpPlayer.getBackButton().setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.evaluation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_evaluate) {
            Toast.makeText(this, "课程评价", Toast.LENGTH_SHORT).show();
            mEtComment.setText("");
            mRatingBar.setCountSelected(0);
            popupWindow.showAtLocation(
                    mVpPlayer,
                    Gravity.CENTER,
                    0,
                    0);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_note:
                Toast.makeText(this, "记笔记", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_comment:
                Toast.makeText(this, "发讨论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_collect:
                Toast.makeText(this, "收藏课程", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_release:
                popupWindow.dismiss();
                break;
        }
    }
}
