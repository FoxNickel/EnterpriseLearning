package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.MyDiscussRecyclerAdapter;

/**
 * Created by Night on 2017/7/14.
 * Desc:
 */

public class MyDiscussActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private RecyclerView mRecyclerViewPlan;
    private SwipeRefreshLayout mSwipeRefresh;
    private TextView mTvMyPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_discuss);
        initView();
    }

    private void initView() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mTvMyPlan = (TextView) findViewById(R.id.tv_my_plan);
        mTvMyPlan.setText("我的讨论");
        mRecyclerViewPlan = (RecyclerView) findViewById(R.id.recycler_view_plan);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyDiscussRecyclerAdapter myDiscussRecyclerAdapter = new MyDiscussRecyclerAdapter(this);
        mRecyclerViewPlan.setLayoutManager(linearLayoutManager);
        mRecyclerViewPlan.setAdapter(myDiscussRecyclerAdapter);
    }
}
