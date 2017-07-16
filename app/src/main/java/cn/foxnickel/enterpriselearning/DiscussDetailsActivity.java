package cn.foxnickel.enterpriselearning;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.DiscussDetailsAdapter;

/**
 * Created by Night on 2017/7/15.
 * Desc:Discuss details activity
 */

public class DiscussDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvPlanName;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private RecyclerView mRecyclerViewMyExam;
    private ImageView mIvOpen;
    private TextView mTvQuestionContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discess_details);
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mRecyclerViewMyExam = (RecyclerView) findViewById(R.id.rl_all_answer);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DiscussDetailsAdapter planContentRecyclerAdapter = new DiscussDetailsAdapter(this);
        mRecyclerViewMyExam.setLayoutManager(linearLayoutManager);
        mRecyclerViewMyExam.setAdapter(planContentRecyclerAdapter);
        mIvOpen = (ImageView) findViewById(R.id.iv_open);
        mIvOpen.setOnClickListener(this);
        mTvQuestionContent = (TextView) findViewById(R.id.tv_question_content);
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
            default:
                break;
        }
    }

    // 动画实际执行
    private void startPropertyAnim(final View v, boolean f) {
        final int tempHight;
        final int maxLines;
        float startangles, endangles;
        final int startHeight;
        if (f) {
            maxLines = 999;
            startangles = 0f;
            endangles = 180f;
        } else {
            maxLines = 0;
            startangles = -180f;
            endangles = 0f;
        }
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(v, "rotation", startangles, endangles);
        anim1.setDuration(500);
        // 回调监听
        anim1.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mTvQuestionContent.setMaxLines(maxLines);
            }
        });

        anim1.start();

    }
}
