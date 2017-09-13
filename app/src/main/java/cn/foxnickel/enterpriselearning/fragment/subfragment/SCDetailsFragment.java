package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.SCRecommendAdapter;
import cn.foxnickel.enterpriselearning.bean.Course;
import cn.foxnickel.enterpriselearning.bean.CourseRecommend;
import cn.foxnickel.enterpriselearning.config.Config;

import static cn.foxnickel.enterpriselearning.config.Config.getTextViewHeight;

/**
 * Created by Night on 2017/7/8.
 * Desc:Specific course details Fragment
 */
public class SCDetailsFragment extends Fragment implements View.OnClickListener {

    private View mRootView;
    private TextView mTvCourseName;//课程名字
    private TextView mTvShortIntro;//简介
    private ImageView mIvOpen;
    private TextView mTvCourseNotes;//课程须知
    private TextView mTvLearningWhat;//老师告诉你能学到什么
    private RecyclerView mRecyclerViewCourseRecommend;//相关课程推荐
    private View mViewDivider1;
    private TextView mTvCredit;//学分
    private ArrayList<CourseRecommend> mList;
    private Course mCourse;

    public SCDetailsFragment() {
        // Required empty public constructor
    }


    public static SCDetailsFragment newInstance() {
        return new SCDetailsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_sc_details, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        mCourse = getArguments().getParcelable("course");
        mTvCredit = (TextView) mRootView.findViewById(R.id.tv_credit);
        mTvCredit.setOnClickListener(this);
        mTvCourseName = (TextView) mRootView.findViewById(R.id.tv_course_name);
        mTvShortIntro = (TextView) mRootView.findViewById(R.id.tv_short_intro);
        mTvShortIntro.setOnClickListener(this);
        mIvOpen = (ImageView) mRootView.findViewById(R.id.iv_open);
        mIvOpen.setOnClickListener(this);
        mTvCourseNotes = (TextView) mRootView.findViewById(R.id.tv_course_notes);
        mTvLearningWhat = (TextView) mRootView.findViewById(R.id.tv_learning_what);
        if (mCourse != null) {
            mTvCredit.setText(mCourse.getCredit() + "学分");
            mTvCourseName.setText(mCourse.getCourseName());
            mTvShortIntro.setText(mCourse.getShortIntro());
            mTvLearningWhat.setText(mCourse.getLearningWhat());
            mTvCourseNotes.setText(mCourse.getCourseNotes());
        }
        mList = new ArrayList<>();

        mList.add(new CourseRecommend("Web", "从零开始HTML5前\n端开发", "介绍常用HTML相关知识", "30人学习"));
        mList.add(new CourseRecommend("Web", "零基础学习前端", "介绍HTML、CSS、js的基础知识", "20人学习"));
        mList.add(new CourseRecommend("Web", "Web前端开发零基\n础入门", "讲解前端基础课程", "100人学习"));
        mList.add(new CourseRecommend("Web", "UI入门小锦囊", "介绍UI设计基础的知识", "25人学习"));

        mRecyclerViewCourseRecommend = (RecyclerView) mRootView.findViewById(R.id.recycler_view_course_recommend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewCourseRecommend.setLayoutManager(linearLayoutManager);
        SCRecommendAdapter courseRecommendAdapter = new SCRecommendAdapter(getContext(), mList);
        mRecyclerViewCourseRecommend.setAdapter(courseRecommendAdapter);
        mViewDivider1 = (View) mRootView.findViewById(R.id.view_divider1);
        mViewDivider1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getTag() == null) {
            v.setTag(true);
        } else {
            v.setTag(!((boolean) v.getTag()));
        }
        switch (v.getId()) {
            case R.id.iv_open:
                startPropertyAnim(v, (boolean) v.getTag());
                break;
            case R.id.view_divider1:
            case R.id.tv_short_intro:
                if (mIvOpen.getTag() == null) {
                    mIvOpen.setTag(true);
                } else {
                    mIvOpen.setTag(!((boolean) mIvOpen.getTag()));
                }
                startPropertyAnim(mIvOpen, (boolean) mIvOpen.getTag());
                break;
            default:
                break;
        }
    }

    // 动画实际执行
    private void startPropertyAnim(final View v, boolean f) {
        final int tempHight;
        final int maxLines;
        float startangles, endangles;
        final int startHeight = mTvShortIntro.getHeight();
        if (f) {
            maxLines = 999;
            startangles = 0f;
            endangles = 180f;
            tempHight = getTextViewHeight(mTvShortIntro) - 2 * mTvShortIntro.getLineHeight();
        } else {
            maxLines = 2;
            startangles = -180f;
            endangles = 0f;
            tempHight = 2 * mTvShortIntro.getLineHeight() - Config.getTextViewHeight(mTvShortIntro);
        }
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(v, "rotation", startangles, endangles);
        anim1.setDuration(500);
        // 回调监听
        anim1.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        Animation animation = new Animation() {
            //interpolatedTime 为当前动画帧对应的相对时间，值总在0-1之间
            protected void applyTransformation(float interpolatedTime, Transformation t) { //根据ImageView旋转动画的百分比来显示textview高度，达到动画效果
                mTvShortIntro.setHeight((int) (startHeight + tempHight * interpolatedTime));//原始长度+高度差*（从0到1的渐变）即表现为动画效果

            }
        };
        animation.setDuration(500);
        anim1.start();
        mTvShortIntro.startAnimation(animation);

    }


}
