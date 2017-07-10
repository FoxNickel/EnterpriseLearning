package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.SCRecommendAdapter;

/**
 * Created by Night on 2017/7/8.
 * Desc:Specific course details Fragment
 */
public class SCDetailsFragment extends Fragment implements View.OnClickListener {

    private View mRootView;
    private TextView mTvCourseName;
    private ImageView mIvCollect;
    private TextView mTvShortIntro;
    private ImageView mIvOpen;
    private TextView mTvCourseNotes;
    private TextView mTvLearningWhat;
    private RecyclerView mRecyclerViewCourseRecommend;


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
        mTvCourseName = (TextView) mRootView.findViewById(R.id.tv_course_name);
        mIvCollect = (ImageView) mRootView.findViewById(R.id.iv_collect);
        mIvCollect.setOnClickListener(this);
        mTvShortIntro = (TextView) mRootView.findViewById(R.id.tv_short_intro);
        mTvShortIntro.setOnClickListener(this);
        mIvOpen = (ImageView) mRootView.findViewById(R.id.iv_open);
        mIvOpen.setOnClickListener(this);
        mTvCourseNotes = (TextView) mRootView.findViewById(R.id.tv_course_notes);
        mTvLearningWhat = (TextView) mRootView.findViewById(R.id.tv_learning_what);
        mRecyclerViewCourseRecommend = (RecyclerView) mRootView.findViewById(R.id.recycler_view_course_recommend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewCourseRecommend.setLayoutManager(linearLayoutManager);
        SCRecommendAdapter courseRecommendAdapter = new SCRecommendAdapter(getContext());
        mRecyclerViewCourseRecommend.setAdapter(courseRecommendAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() == null) {
            v.setTag(true);
        } else {
            v.setTag(!((boolean) v.getTag()));
        }
        switch (v.getId()) {
            case R.id.iv_collect:
                if ((boolean) v.getTag()) {
                    v.setBackgroundResource(R.drawable.ic_collect_red);
                } else {
                    v.setBackgroundResource(R.drawable.ic_collect_gray);
                }
                break;
            case R.id.iv_open:
                startPropertyAnim(v, (boolean) v.getTag());
                break;
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
            tempHight = 2 * mTvShortIntro.getLineHeight() - getTextViewHeight(mTvShortIntro);
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

    private int getTextViewHeight(TextView pTextView) {
        Layout layout = pTextView.getLayout();
        int desired = layout.getLineTop(pTextView.getLineCount());
        int padding = pTextView.getCompoundPaddingTop() + pTextView.getCompoundPaddingBottom();
        return desired + padding;
    }
}
