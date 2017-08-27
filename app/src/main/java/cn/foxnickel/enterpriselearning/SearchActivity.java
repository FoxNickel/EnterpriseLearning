package cn.foxnickel.enterpriselearning;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.SearchViewPagerAdapter;
import cn.foxnickel.enterpriselearning.bean.Cheeses;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SearchCourseFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SearchNoteFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SearchPlanFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SearchTaskFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.SearchTrainingFragment;

/**
 * Created by Night on 2017/7/24.
 * Desc:
 */

public class SearchActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerViewNote;
    private SearchView mSearchView;
    private SimpleCursorAdapter mAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private TextView mTvCourseCount;
    private SearchView.SearchAutoComplete searchAutoComplete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }


    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mRecyclerViewNote = (RecyclerView) findViewById(R.id.recycler_view_note);
        mSearchView = (SearchView) findViewById(R.id.search_view);
        mSearchView.setIconified(false);
        mSearchView.setSubmitButtonEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_search);

        searchAutoComplete = (SearchView.SearchAutoComplete) mSearchView.findViewById(R.id.search_src_text);
        searchAutoComplete.setThreshold(1);//设置触发查询的最少字符数
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(SearchCourseFragment.newInstance());
        fragmentList.add(SearchTaskFragment.newInstance());
        fragmentList.add(SearchPlanFragment.newInstance());
        fragmentList.add(SearchTrainingFragment.newInstance());
        fragmentList.add(SearchNoteFragment.newInstance());
        SearchViewPagerAdapter searchViewPagerAdapter = new SearchViewPagerAdapter(getSupportFragmentManager(), this, fragmentList);
        mViewPager.setAdapter(searchViewPagerAdapter);
        mTvCourseCount = (TextView) findViewById(R.id.tv_course_count);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mTvCourseCount.setText("共2门课程");
                        break;
                    case 1:
                        mTvCourseCount.setText("共0个任务");
                        break;
                    case 2:
                        mTvCourseCount.setText("共0个计划");
                        break;
                    case 3:
                        mTvCourseCount.setText("共0个培训");
                        break;
                    case 4:
                        mTvCourseCount.setText("共5条笔记");
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);


        // 监听搜索框文字变化
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mTabLayout.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.VISIBLE);
                mLinearLayout.setVisibility(View.VISIBLE);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Cursor cursor = TextUtils.isEmpty(s) ? null : queryData(s);

                if (mSearchView.getSuggestionsAdapter() == null) {
                    mAdapter = new SimpleCursorAdapter(SearchActivity.this, R.layout.item_layout, cursor, new String[]{"name"}, new int[]{R.id.text1});
                    mSearchView.setSuggestionsAdapter(mAdapter);
                } else {
                    mSearchView.getSuggestionsAdapter().changeCursor(cursor);
                }
                return false;
            }
        });
        mSearchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                Cursor c = (Cursor) mAdapter.getItem(position);
                String query = c.getString(c.getColumnIndex("name"));
                searchAutoComplete.setText(query);
                mTabLayout.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.VISIBLE);
                mLinearLayout.setVisibility(View.VISIBLE);
                return false;
            }
        });
        // mSearchView.setOnClickListener(this);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    }

    private Cursor queryData(String key) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + "music.db", null);
        Cursor cursor;
        try {
            String querySql = "select * from tb_music where name like '%" + key + "%'";
            cursor = db.rawQuery(querySql, null);
            Log.e("CSDN_LQR", "querySql = " + querySql);
        } catch (Exception e) {
            e.printStackTrace();
            String createSql = "create table tb_music (_id integer primary key autoincrement,name varchar(100))";
            db.execSQL(createSql);

            String insertSql = "insert into tb_music values (null,?)";
            for (int i = 0; i < Cheeses.sCheeseStrings.length; i++) {
                db.execSQL(insertSql, new String[]{Cheeses.sCheeseStrings[i]});
            }

            String querySql = "select * from tb_music where name like '%" + key + "%'";
            cursor = db.rawQuery(querySql, null);

            Log.e("CSDN_LQR", "createSql = " + createSql);
            Log.e("CSDN_LQR", "querySql = " + querySql);
        }
        return cursor;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (TextUtils.isEmpty(searchAutoComplete.getText().toString().trim())) {
                    finish();
                } else {
                    searchAutoComplete.setText("");
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (TextUtils.isEmpty(searchAutoComplete.getText().toString().trim())) {
            finish();
        } else {
            searchAutoComplete.setText("");
        }
    }
}
