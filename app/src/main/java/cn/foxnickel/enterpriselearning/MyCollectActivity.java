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

import cn.foxnickel.enterpriselearning.adapter.MyCollectRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Course;

import static com.mob.MobSDK.getContext;

/**
 * Created by Night on 2017/7/13.
 * Desc:My plan activity
 */

public class MyCollectActivity extends AppCompatActivity {

    private TextView mTvPlanName;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private RecyclerView mRecyclerViewMyTask;
    private SwipeRefreshLayout mExamSwipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
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
        mRecyclerViewMyTask = (RecyclerView) findViewById(R.id.recycler_view_plan);
        mExamSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Java-从入门到精通", Integer.toString(R.drawable.java1), 4, "2017-07-25", 10));
        courseList.add(new Course("Android网络与数据存储", Integer.toString(R.drawable.android2), 5, "2017-07-24", 80));
        courseList.add(new Course("Python自动化运维篇", Integer.toString(R.drawable.python1), 4, "2017-07-23", 70));
        courseList.add(new Course("Java面向对象", Integer.toString(R.drawable.java2), 4, "2017-07-21", 80));
        courseList.add(new Course("Python装饰器", Integer.toString(R.drawable.python2), 4, "2017-07-22", 100));
        MyCollectRecyclerAdapter myCourseRecyclerAdapter = new MyCollectRecyclerAdapter(getContext(), courseList);
        mRecyclerViewMyTask.setLayoutManager(linearLayoutManager);
        mRecyclerViewMyTask.setAdapter(myCourseRecyclerAdapter);
    }
}
