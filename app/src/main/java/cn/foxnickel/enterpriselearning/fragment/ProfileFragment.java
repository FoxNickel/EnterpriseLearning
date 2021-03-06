package cn.foxnickel.enterpriselearning.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.HistoryActivity;
import cn.foxnickel.enterpriselearning.LearningDataActivity;
import cn.foxnickel.enterpriselearning.MyCollectActivity;
import cn.foxnickel.enterpriselearning.MyDiscussActivity;
import cn.foxnickel.enterpriselearning.MyPlanActivity;
import cn.foxnickel.enterpriselearning.MyTrainingActivity;
import cn.foxnickel.enterpriselearning.NoteActivity;
import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SettingsActivity;
import cn.foxnickel.enterpriselearning.TaskActivity;
import cn.foxnickel.enterpriselearning.UserInfoActivity;
import cn.foxnickel.enterpriselearning.config.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private View mRootView;
    private View mSettingView;
    private View mUerInfo;
    private ImageView mIvMyData, mIvMyQuestion, mIvMyHistory;
    private TextView mTvMyData, mTvMyQuestion, mTvMyHistory;
    private TextView mTvMyPlan;
    private ImageView mIvMyPlan;
    private ConstraintLayout mLayoutMyPlan;
    private ConstraintLayout mLayoutMyTask;
    private ConstraintLayout mLayoutMyNote;
    private ConstraintLayout mLayoutMyTraining;
    private TextView mTvMyCollect;
    private ImageView mIvMyCollect;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_profile, container, false);
        Config.fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
        initView();
        return mRootView;
    }

    private void initView() {
        mSettingView = mRootView.findViewById(R.id.layout_setting);
        mSettingView.setOnClickListener(this);

        mUerInfo = mRootView.findViewById(R.id.layout_user_info);
        mUerInfo.setOnClickListener(this);

        mIvMyData = (ImageView) mRootView.findViewById(R.id.iv_my_data);
        mIvMyData.setOnClickListener(this);
        mTvMyData = (TextView) mRootView.findViewById(R.id.tv_my_data);
        mTvMyData.setOnClickListener(this);

        mIvMyQuestion = (ImageView) mRootView.findViewById(R.id.iv_my_question);
        mIvMyQuestion.setOnClickListener(this);
        mTvMyQuestion = (TextView) mRootView.findViewById(R.id.tv_my_question);
        mTvMyQuestion.setOnClickListener(this);

        mIvMyHistory = (ImageView) mRootView.findViewById(R.id.iv_my_history);
        mIvMyHistory.setOnClickListener(this);
        mTvMyHistory = (TextView) mRootView.findViewById(R.id.tv_my_history);
        mTvMyHistory.setOnClickListener(this);
        mTvMyPlan = (TextView) mRootView.findViewById(R.id.tv_my_plan);
        mTvMyPlan.setOnClickListener(this);
        mIvMyPlan = (ImageView) mRootView.findViewById(R.id.iv_my_plan);
        mIvMyPlan.setOnClickListener(this);
        mLayoutMyPlan = (ConstraintLayout) mRootView.findViewById(R.id.layout_my_plan);
        mLayoutMyPlan.setOnClickListener(this);
        mLayoutMyTask = (ConstraintLayout) mRootView.findViewById(R.id.layout_my_task);
        mLayoutMyTask.setOnClickListener(this);
        mLayoutMyNote = (ConstraintLayout) mRootView.findViewById(R.id.layout_my_note);
        mLayoutMyNote.setOnClickListener(this);
        mLayoutMyTraining = (ConstraintLayout) mRootView.findViewById(R.id.layout_my_training);
        mLayoutMyTraining.setOnClickListener(this);
        mTvMyCollect = (TextView) mRootView.findViewById(R.id.tv_my_collect);
        mTvMyCollect.setOnClickListener(this);
        mIvMyCollect = (ImageView) mRootView.findViewById(R.id.iv_my_collect);
        mIvMyCollect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_setting:
                startActivity(new Intent(getContext(), SettingsActivity.class));
                break;
            case R.id.layout_user_info:
                startActivity(new Intent(getContext(), UserInfoActivity.class));
                break;
            case R.id.iv_my_data:
            case R.id.tv_my_data:
                startActivity(new Intent(getContext(), LearningDataActivity.class));
                break;
            case R.id.iv_my_question:
            case R.id.tv_my_question:
                startActivity(new Intent(getContext(), MyDiscussActivity.class));
                break;
            case R.id.iv_my_history:
            case R.id.tv_my_history:
                startActivity(new Intent(getContext(), HistoryActivity.class));
                break;
            case R.id.iv_my_collect:
            case R.id.tv_my_collect:
                startActivity(new Intent(getContext(), MyCollectActivity.class));
                break;
            case R.id.layout_my_plan:
                startActivity(new Intent(getContext(), MyPlanActivity.class));
                break;
            case R.id.layout_my_task:
                startActivity(new Intent(getContext(), TaskActivity.class));
                break;
            case R.id.layout_my_note:
                startActivity(new Intent(getContext(), NoteActivity.class));
                break;
            case R.id.layout_my_training:
                startActivity(new Intent(getContext(), MyTrainingActivity.class));
                break;

        }
    }
}
