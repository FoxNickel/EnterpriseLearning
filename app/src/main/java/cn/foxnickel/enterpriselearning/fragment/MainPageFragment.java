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
import android.widget.Toast;

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
        mBGABanner.setData(R.drawable.login_bg2, R.drawable.login_bg2, R.drawable.login_bg4, R.drawable.login_bg4);
        mBGABanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                Intent startTrainingDetailActivity = new Intent(getContext(), TrainingDetailActivity.class);
                startTrainingDetailActivity.putExtra("training_name", "这是培训名称");
                startTrainingDetailActivity.putExtra("training_intro", "        这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍");
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
        mList.add(new CourseRecommend("设计基础", "UI设计小锦囊", "成为UI设计师的正确打开方法", "3000人学习"));
        mList.add(new CourseRecommend("Android", "Android常用异常集及解决方案", "介绍Android常用异常集及解决方案", "3000人学习"));
        mList.add(new CourseRecommend("Android", "Android语音词典", "讲解第三方讯飞语音如何使用，如何实现数据解析", "3000人学习"));
        mList.add(new CourseRecommend("Android", "APP性能优化之内存优化", "介绍内存优化的理论，优化的问题，方法等知识，如何实现数据解析", "3000人学习"));

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
                Toast.makeText(getContext(), "任务", Toast.LENGTH_SHORT).show();
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
                        "3、友盟实现第三方登录", "3000人学习"));
                mList.add(new CourseRecommend("Android", "Android Multidex原理及实现", "介绍如何通过DexClassLoader动态加载分dex。", "3000人学习"));
                mList.add(new CourseRecommend("Android", "自定义实现顶部粘性下拉刷新效果", "利用贝塞尔曲线，自定义实现粘性下拉控件", "3000人学习"));
                mList.add(new CourseRecommend("Android", "Android-心愿分享", "介绍：1、调用手机系统图库\n" +
                        "2、添加自定义字体", "3000人学习"));
                mCourseRecommendAdapter.notifyDataSetChanged();
                break;
        }
    }
}
