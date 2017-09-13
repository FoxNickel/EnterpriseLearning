package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.xlhratingbar_lib.XLHRatingBar;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.SpecificCoursePagerAdapter;
import cn.foxnickel.enterpriselearning.bean.Chapter;
import cn.foxnickel.enterpriselearning.bean.Course;
import cn.foxnickel.enterpriselearning.bean.Note;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCChaptersFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCDetailsFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCNoteFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SCQAFragment;
import cn.foxnickel.enterpriselearning.module.SwitchVideoModel;
import cn.foxnickel.enterpriselearning.utils.DisplayUtil;
import cn.foxnickel.enterpriselearning.utils.Resources;
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
    private FloatingActionMenu mFloatingActionMenu;
    //popupwindow组件
    private LayoutInflater mLayoutInflater;
    View popupView;
    PopupWindow popupWindow;
    private EditText mEtComment;
    private Button mBtRelease;
    private XLHRatingBar mRatingBar;
    private AlertDialog mDialog;
    private String mCourseName;
    private Course mCourse;

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
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
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
        Bundle bundle1 = getIntent().getExtras();
        mCourse = null;
        if (bundle1 != null) {
            mCourse = bundle1.getParcelable("course");
        }
        if (mCourse == null) {
            List<Chapter> chapters = new ArrayList<>();
            List<Note> notes = new ArrayList<>();
            chapters.add(new Chapter("第1章 webUI课程简介", true, null, ""));
            chapters.add(new Chapter("1-1课程介绍", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
            chapters.add(new Chapter("第2章 从设计角度初识web页面", true, null, ""));
            chapters.add(new Chapter("2-1 webUI是什么", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
            chapters.add(new Chapter("2-2 关于分辨率", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
            chapters.add(new Chapter("2-3 web的基本分类", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
            chapters.add(new Chapter("2-4 网页是如何实现的", false, Resources.VIDEO, "http://112.17.2.183/video.study.163.com/edu-video/nos/mp4/2017/04/27/1006157378_79df7d044dc644c0b0abdacc51f3f7dc_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee4e96dd59549ea432cc13c8ad7b52a9e476d57ed0438f9d1ecf50b33bb61d8c7b8760bbae5996a1ed191108c718bc022fc5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b7bd9f&wsid_tag=700ab4b2&wsiphost=ipdbm"));
            notes.add(new Note("源自:web UI设计理论入门-网页是如何实现的", "web 标准化布局原理\n" +
                    "把网页看成多个网格\n" +
                    "先有行再有列（从上到下）\n" +
                    "先做容器再做内容（从外到内）", "2017-07-10"));
            notes.add(new Note("源自:web UI设计理论入门-关于分辨率", "分辨率：水平和垂直像素个数", "2017-07-09"));
            notes.add(new Note("源自:web UI设计理论入门-webUI是什么", "UI的3个方向：\n" +
                    "1.用户研究\n" +
                    "2.交互设计\n" +
                    "3.界面设计", "2017-07-08"));
            notes.add(new Note("源自:web UI设计理论入门-课程介绍", "ie9+、chrome、flex及主流浏览器都可兼容css3", "2017-07-07"));
            notes.add(new Note("源自:web UI设计理论入门-课程介绍", "ps里面有切片工具可以用来切图", "2017-07-07"));

            mCourse = new Course("Web UI设计理论入门", chapters, 2, "网页在我们生活中已经占据了重要地位,相对于移动端，web的优点是信息展示更具多样性。我们在课程中为大家详细的剖析web的特征属性、构成、设计逻辑等，为webUI设计提供扎实的理论基础。"
                    , "本课程是webUI的入门课程,以理论与赏析为主，\n没有门槛", "1、教你如何从设计的角度去了解web\n"
                    + "2、明白设计思路，我们更多的使用脑而不是用软件去做设计\n"
                    + "3、设计流程和设计规范的重要性\n"
                    + "4、学会分析页面，逆向解析作品", notes);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("course", mCourse);
        SCChaptersFragment scChaptersFragment = SCChaptersFragment.newInstance();
        scChaptersFragment.setArguments(bundle);
        SCDetailsFragment scDetailsFragment = SCDetailsFragment.newInstance();
        SCQAFragment scQAFragment = SCQAFragment.newInstance();
        scQAFragment.setArguments(bundle);
        SCNoteFragment scNoteFragment = SCNoteFragment.newInstance();
        scNoteFragment.setArguments(bundle);
        scDetailsFragment.setArguments(bundle);
        fragmentList.add(scChaptersFragment);
        fragmentList.add(scDetailsFragment);
        fragmentList.add(scQAFragment);
        fragmentList.add(scNoteFragment);
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
        mFloatingActionMenu = (FloatingActionMenu) findViewById(R.id.float_menu);
    }

    private void setupVideo() {
        Chapter chapter = mCourse.getChapters().get(1);
        String source1 = chapter.getUrl();
        String name = "普通";
        SwitchVideoModel switchVideoModel = new SwitchVideoModel(name, source1);

        String source2 = chapter.getUrl();
        String name2 = "清晰";
        SwitchVideoModel switchVideoModel2 = new SwitchVideoModel(name2, source2);

        List<SwitchVideoModel> list = new ArrayList<>();
        list.add(switchVideoModel);
        list.add(switchVideoModel2);

        mVpPlayer.setUp(list, true, "");


        //增加title
        mVpPlayer.getTitleTextView().setVisibility(View.VISIBLE);
      /*  mVpPlayer.getTitleTextView().setText("测试视频");*/

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
            mFloatingActionMenu.setVisibility(View.GONE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dp2px(this, 240f));
            isFullScreen = false;
            mToolbar.setVisibility(View.VISIBLE);
            mFloatingActionMenu.setVisibility(View.VISIBLE);
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
      /*      mEtComment.setText("");
            mRatingBar.setCountSelected(0);
            popupWindow.showAtLocation(
                    mVpPlayer,
                    Gravity.CENTER,
                    0,
                    0);*/
            mVpPlayer.onVideoPause();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            mDialog = builder.create();
            View view = View.inflate(this, R.layout.popupwindow_course_score, null);
            Button release = (Button) view.findViewById(R.id.bt_release);
            release.setOnClickListener(this);
            int density = (int) ScreenUtil.getDeviceDensity(this);
            mDialog.setView(view, 0, 0, 0, 0);
            mDialog.show();
            Window dialogWindow = mDialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = 300 * density;
            lp.height = 300 * density;
            dialogWindow.setAttributes(lp);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_note:
                startActivity(new Intent(SpecificCouseActivity.this, WriteNoteActivity.class));
                break;
            case R.id.fab_comment:
                startActivity(new Intent(SpecificCouseActivity.this, WriteDiscussActivity.class));
                break;
            case R.id.fab_collect:
                Toast.makeText(this, "收藏课程", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_release:
                Toast.makeText(this, "评价成功", Toast.LENGTH_SHORT).show();
                mDialog.cancel();
                break;
        }
    }
}
