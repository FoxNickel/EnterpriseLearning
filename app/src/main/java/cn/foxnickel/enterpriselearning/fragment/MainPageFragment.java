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
import android.widget.Toast;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.foxnickel.enterpriselearning.NoteActivity;
import cn.foxnickel.enterpriselearning.PlanActivity;
import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.TrainingActivity;
import cn.foxnickel.enterpriselearning.adapter.CourseRecommendAdapter;

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
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;
    private CourseRecommendAdapter mCourseRecommendAdapter;

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
    }

    private void initView() {
        mIvNote = (ImageView) mRootView.findViewById(R.id.iv_note);
        mIvTraining = (ImageView) mRootView.findViewById(R.id.iv_training);
        mIvPlan = (ImageView) mRootView.findViewById(R.id.iv_plan);
        mIvTask = (ImageView) mRootView.findViewById(R.id.iv_task);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);

        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        mCourseRecommendAdapter = new CourseRecommendAdapter(getContext());

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
        }
    }
}
