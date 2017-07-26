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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.MyPlanRecyclerAdapter;

/**
 * Created by Night on 2017/7/13.
 * Desc:My plan activity
 */

public class MyPlanActivity extends AppCompatActivity {

    private TextView mTvPlanName;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private RecyclerView mRecyclerViewMyExam;
    private SwipeRefreshLayout mExamSwipeRefresh;
    private List<String> mPlanNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan);

        mPlanNameList = new ArrayList<>();
        mPlanNameList.add("新员工入职计划");
        mPlanNameList.add("Android强化:" + "\n\n" + "网络与数据存储");
        mPlanNameList.add("Android强化:" + "\n\n" + "高级动画开发");

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
        mRecyclerViewMyExam = (RecyclerView) findViewById(R.id.recycler_view_plan);
        mExamSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyPlanRecyclerAdapter planContentRecyclerAdapter = new MyPlanRecyclerAdapter(this, mPlanNameList);
        mRecyclerViewMyExam.setLayoutManager(linearLayoutManager);
        mRecyclerViewMyExam.setAdapter(planContentRecyclerAdapter);
    }
}
