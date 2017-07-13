package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.SpecificPlanRecyclerAdapter;

/**
 * Created by Night on 2017/7/11.
 * Desc:
 */

public class SpecificPlanActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mExamSwipeRefresh;
    private SpecificPlanRecyclerAdapter mSpecificPlanRecyclerAdapter;
    private Toolbar mToolbar;
    private TextView mTvPlanName;

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
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_my_exam);
        mExamSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.exam_swipe_refresh);
        mSpecificPlanRecyclerAdapter = new SpecificPlanRecyclerAdapter(SpecificPlanActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SpecificPlanActivity.this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mSpecificPlanRecyclerAdapter);
        mTvPlanName = (TextView) findViewById(R.id.tv_plan_name);
        mTvPlanName.setText(getIntent().getStringExtra("planname"));
    }

}
