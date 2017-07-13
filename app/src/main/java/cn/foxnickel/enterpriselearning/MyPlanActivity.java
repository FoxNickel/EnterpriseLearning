package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.PlanContentRecyclerAdapter;

/**
 * Created by Night on 2017/7/13.
 * Desc:
 */

public class MyPlanActivity extends AppCompatActivity {

    private TextView mTvPlanName;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private RecyclerView mRecyclerViewMyExam;
    private SwipeRefreshLayout mExamSwipeRefresh;
    private FrameLayout mFlPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_specific);
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
        mTvPlanName = (TextView) findViewById(R.id.tv_plan_name);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mTvPlanName.setText(R.string.my_plan);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mRecyclerViewMyExam = (RecyclerView) findViewById(R.id.recycler_view_my_exam);
        mExamSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.exam_swipe_refresh);
        mFlPlan = (FrameLayout) findViewById(R.id.fl_plan_fragment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        PlanContentRecyclerAdapter planContentRecyclerAdapter = new PlanContentRecyclerAdapter(this);
        mRecyclerViewMyExam.setLayoutManager(linearLayoutManager);
        mRecyclerViewMyExam.setAdapter(planContentRecyclerAdapter);
    }
}
