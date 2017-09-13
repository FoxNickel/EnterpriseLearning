package cn.foxnickel.enterpriselearning.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.foxnickel.enterpriselearning.NoteActivity;
import cn.foxnickel.enterpriselearning.PlanActivity;
import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.TaskActivity;
import cn.foxnickel.enterpriselearning.TrainingActivity;
import cn.foxnickel.enterpriselearning.TrainingDetailActivity;
import cn.foxnickel.enterpriselearning.adapter.CourseRecommendAdapter;
import cn.foxnickel.enterpriselearning.bean.CourseRecommend;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment implements View.OnClickListener {

    private View mRootView;
    private BGABanner mBGABanner;
    private View view;
    private ImageView mIvNote;
    private ImageView mIvTraining;
    private ImageView mIvPlan;
    private ImageView mIvTask;
    private TextView mTvChange;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private CourseRecommendAdapter mCourseRecommendAdapter;
    private List<CourseRecommend> mList;

    public MainPageFragment() {
        // Required empty public constructor
    }

    public static MainPageFragment newInstance() {
        return new MainPageFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_page, container, false);
        initView();
        initBanner();
        return mRootView;
    }

    private void initBanner() {
        mBGABanner = (BGABanner) mRootView.findViewById(R.id.banner);
        mBGABanner.setData(R.drawable.arc_tech1, R.drawable.arc_tech2, R.drawable.arc_tech3, R.drawable.arc_tech4);
        mBGABanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                Intent startTrainingDetailActivity = new Intent(getContext(), TrainingDetailActivity.class);
                startTrainingDetailActivity.putExtra("training_name", "新员工入职培训");
                startTrainingDetailActivity.putExtra("training_intro", "针对公司七月所有新进员工进行培训");
                startTrainingDetailActivity.putExtra("training_num", "报名人数:36人");
                startTrainingDetailActivity.putExtra("training_place", "培训地点:二楼会议室");
                startTrainingDetailActivity.putExtra("training_start_time", "开始时间:2017年7月7日 12:00");
                startTrainingDetailActivity.putExtra("training_duration", "培训时长:2小时");
                startActivity(startTrainingDetailActivity);
            }
        });
    }

    private void initView() {
        mIvNote = (ImageView) mRootView.findViewById(R.id.iv_note);
        mIvTraining = (ImageView) mRootView.findViewById(R.id.iv_training);
        mIvPlan = (ImageView) mRootView.findViewById(R.id.iv_plan);
        mIvTask = (ImageView) mRootView.findViewById(R.id.iv_task);
        mTvChange = (TextView) mRootView.findViewById(R.id.tv_change);
        mTvChange.setOnClickListener(this);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);

        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        mList = new ArrayList<>();
        mList.add(new CourseRecommend("Web", "Web UI设计理论入门", "介绍Web UI的入门课程", "30人学习"));
        mList.add(new CourseRecommend("Android", "kotlin从零基础到进阶", "介绍kotlin基础、进阶知识", "200人学习"));
        mList.add(new CourseRecommend("Java", "Java基础-反射", "讲解Java中反射如何使用", "100人学习"));
        mList.add(new CourseRecommend("Android", "Android自动化测试", "介绍Android自动化测试相关知识", "25人学习"));

        mCourseRecommendAdapter = new CourseRecommendAdapter(getContext(), mList);

        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mCourseRecommendAdapter);

        mIvTask.setOnClickListener(this);
        mIvPlan.setOnClickListener(this);
        mIvTraining.setOnClickListener(this);
        mIvNote.setOnClickListener(this);
        /*
         * 解决ScrollView里面布局很长的时候会自动滑动到底部的问题
         */
        mIvTask.setFocusable(true);
        mIvTask.setFocusableInTouchMode(true);
        mIvTask.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_task:
                startActivity(new Intent(getContext(), TaskActivity.class));
                break;
            case R.id.iv_plan:
                startActivity(new Intent(getContext(), PlanActivity.class));
                break;
            case R.id.iv_training:
                startActivity(new Intent(getActivity(), TrainingActivity.class));
                break;
            case R.id.iv_note:
                startActivity(new Intent(getActivity(), NoteActivity.class));
                break;
            case R.id.tv_change:
                mList.clear();
                mList.add(new CourseRecommend("Android", "Android-QQ登录", "介绍1、登录流程" +
                        "2、官方DEMO" +
                        "3、友盟实现第三方登录", "30人学习"));
                mList.add(new CourseRecommend("Android", "Android Multidex原理及实现", "介绍如何通过DexClassLoader动态加载分dex。", "20人学习"));
                mList.add(new CourseRecommend("Android", "自定义实现顶部粘性下拉刷新效果", "利用贝塞尔曲线，自定义实现粘性下拉控件", "40人学习"));
                mList.add(new CourseRecommend("Android", "Android-心愿分享", "介绍：1、调用手机系统图库\n" +
                        "2、添加自定义字体", "10人学习"));
                mCourseRecommendAdapter.notifyDataSetChanged();
                break;
        }
    }
}
