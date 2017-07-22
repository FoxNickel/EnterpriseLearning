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
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.CourseListRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Course;

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
    private List<Course> mCourseList;
    private CourseListRecyclerAdapter mCourseListRecyclerAdapter;

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
        mCourseList = new ArrayList<>();
        mCourseList.add(new Course("web UI设计理论入门", "", 3));
        mCourseList.add(new Course("UI设计小锦囊", "", 4));
        mCourseList.add(new Course("Android常用异常集及解决方案", "", 5));
        mCourseList.add(new Course("APP性能优化之内存优化", "", 4));
        mCourseList.add(new Course("Android Multidex原理及实现", "", 3));
        mCourseListRecyclerAdapter = new CourseListRecyclerAdapter(this, mCourseList);
        mRecyclerViewNote.setAdapter(mCourseListRecyclerAdapter);
        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mCourseList.clear();
                        mCourseList.add(new Course("web UI设计理论入门", "", 3));
                        mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        mCourseList.add(new Course("Android常用异常集及解决方案", "", 5));
                        mCourseList.add(new Course("APP性能优化之内存优化", "", 4));
                        mCourseList.add(new Course("Android Multidex原理及实现", "", 3));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mCourseList.clear();
                        mCourseList.add(new Course("Android Multidex原理及实现", "", 3));
                        mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        mCourseList.add(new Course("web UI设计理论入门", "", 3));
                        mCourseList.add(new Course("APP性能优化之内存优化", "", 4));
                        mCourseList.add(new Course("Android常用异常集及解决方案", "", 5));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        Collections.sort(mCourseList);
                        Collections.reverse(mCourseList);
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mCourseList.clear();
                        mCourseList.add(new Course("web UI设计理论入门", "", 3));
                        mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        mCourseList.add(new Course("Android常用异常集及解决方案", "", 5));
                        mCourseList.add(new Course("APP性能优化之内存优化", "", 4));
                        mCourseList.add(new Course("Android Multidex原理及实现", "", 3));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mCourseList.clear();
                        mCourseList.add(new Course("Android Multidex原理及实现", "", 3));
                        mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        mCourseList.clear();
                        mCourseList.add(new Course("web UI设计理论入门", "", 3));
                        mCourseList.add(new Course("APP性能优化之内存优化", "", 4));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        mCourseList.clear();
                        mCourseList.add(new Course("Android常用异常集及解决方案", "", 5));
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
