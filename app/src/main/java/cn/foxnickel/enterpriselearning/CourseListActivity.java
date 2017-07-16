package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.adapter.CourseListRecyclerAdapter;

/**
 * Created by Night on 2017/7/15.
 * Desc:Course List Activity
 */

public class CourseListActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Toolbar mToolbar;
    private TextView mTvCourseCount;
    private Spinner mSpinner2;
    private Spinner mSpinner;
    private RecyclerView mRecyclerViewNote;
    private SwipeRefreshLayout mSwipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
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
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText(getIntent().getStringExtra("title"));
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvCourseCount = (TextView) findViewById(R.id.tv_course_count);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mRecyclerViewNote = (RecyclerView) findViewById(R.id.recycler_view_note);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewNote.setLayoutManager(linearLayoutManager);
        CourseListRecyclerAdapter courseListRecyclerAdapter = new CourseListRecyclerAdapter(this);
        mRecyclerViewNote.setAdapter(courseListRecyclerAdapter);
    }
}
