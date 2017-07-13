package cn.foxnickel.enterpriselearning;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.CourseOutlineRecyclerAdapter;
import cn.foxnickel.enterpriselearning.utils.FullyLinearLayoutManager;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Night on 2017/7/12.
 * Desc:
 */

public class CourseActivity extends AppCompatActivity {
    private ImageView mBackdrop;//课程背景图
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private AppBarLayout mAppbar;
    private TextView mTvCourseLevel;
    private TextView mTvShortCourseIntro;
    private CircleImageView mIvLecturer;
    private TextView mTvLecturerName;
    private TextView mTvLecturerCareer;
    private RelativeLayout mRlLecturer;
    private TextView mOverallScore;
    private TextView mTvOverallScore;
    private TextView mTvAllScore;
    private CircleImageView mIvWorker;
    private TextView mTvWorkerName;
    private TextView mTvScoreContent;
    private RelativeLayout mRlScore;
    private TextView mTvCourseNote;
    private TextView mTvCourseNotes;
    private TextView mTvLearningWhat;
    private String mTitle;
    private WindowManager.LayoutParams lp;
    public static WindowManager wm;
    private Handler popupHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:

                    break;
            }
        }

    };
    public static Button mButton;
    private RecyclerView mRvCourseOutline;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unstart_course);
        Bundle bundle = this.getIntent().getExtras();
        mTitle = bundle.getString("title");
        initView();
        popupHandler.sendEmptyMessageDelayed(0, 1000);
    }

    private void initView() {
        mBackdrop = (ImageView) findViewById(R.id.backdrop);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mAppbar = (AppBarLayout) findViewById(R.id.appbar);
        mTvCourseLevel = (TextView) findViewById(R.id.tv_course_level);
        mTvShortCourseIntro = (TextView) findViewById(R.id.tv_short_course_intro);
        mIvLecturer = (CircleImageView) findViewById(R.id.iv_lecturer);
        mTvLecturerName = (TextView) findViewById(R.id.tv_lecturer_name);
        mTvLecturerCareer = (TextView) findViewById(R.id.tv_lecturer_career);
        mRlLecturer = (RelativeLayout) findViewById(R.id.rl_lecturer);
        mOverallScore = (TextView) findViewById(R.id.overall_score);
        mTvOverallScore = (TextView) findViewById(R.id.tv_overall_score);
        mTvAllScore = (TextView) findViewById(R.id.tv_all_score);
        mIvWorker = (CircleImageView) findViewById(R.id.iv_worker);
        mTvWorkerName = (TextView) findViewById(R.id.tv_worker_name);
        mTvScoreContent = (TextView) findViewById(R.id.tv_score_content);
        mRlScore = (RelativeLayout) findViewById(R.id.rl_score);
        mTvCourseNote = (TextView) findViewById(R.id.tv_course_note);
        mTvCourseNotes = (TextView) findViewById(R.id.tv_course_notes);
        mTvLearningWhat = (TextView) findViewById(R.id.tv_learning_what);
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);//控制窗体的显示和隐藏以及设置所在位置
        mCollapsingToolbar.setTitle(mTitle);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mRvCourseOutline = (RecyclerView) findViewById(R.id.rv_course_outline);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        CourseOutlineRecyclerAdapter courseOutlineRecyclerAdapter = new CourseOutlineRecyclerAdapter(CourseActivity.this);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //linearLayoutManager.setAutoMeasureEnabled(true);
        mRvCourseOutline.setLayoutManager(linearLayoutManager);
        // mRvCourseOutline.setHasFixedSize(true);
        mRvCourseOutline.setNestedScrollingEnabled(false);
        mRvCourseOutline.setAdapter(courseOutlineRecyclerAdapter);
        //添加开始学习Button
        mButton = new Button(CourseActivity.this);
        mButton.setText("开始学习");
        mButton.setBackgroundResource(R.color.colorPrimary);
        mButton.setTextSize(16f);
        mButton.setTextColor(Color.WHITE);
        mButton.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.removeView(mButton);
                mButton = null;
                finish();
                startActivity(new Intent(CourseActivity.this, SpecificCouseActivity.class));
            }
        });
        lp = new WindowManager.LayoutParams();
        lp.width = getScreenWidth();
        lp.height = 120;
        lp.gravity = Gravity.BOTTOM;
        lp.x = 0;
        lp.y = 0;
        lp.type = WindowManager.LayoutParams.TYPE_PHONE;//设置小球的权限级别为电话级别  便于在所有界面上显示。
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;//防止小球抢占焦点
        lp.format = PixelFormat.RGBA_8888;//设置背景为透明的
        wm.addView(mButton, lp);

    }

    public void checkin(View view) {
        if (view.getTag() == null) {
            view.setTag(true);
        } else {
            view.setTag(!((boolean) view.getTag()));
        }
        if ((boolean) view.getTag()) {
            ((FloatingActionButton) view).setImageResource(R.drawable.ic_five_stars_red);
        } else {
            ((FloatingActionButton) view).setImageResource(R.drawable.ic_five_stars_gray);
        }

    }

    public static int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    @Override
    public void onBackPressed() {
        if (mButton != null) {
            wm.removeViewImmediate(mButton);
            mButton = null;
        }
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (mButton != null) {
            wm.removeViewImmediate(mButton);
            mButton = null;
        }
        super.onDestroy();
    }
}
