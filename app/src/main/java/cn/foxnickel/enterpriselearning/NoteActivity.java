package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.NoteRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Note;

public class NoteActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<Note> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mList = new ArrayList<>();
        mList.add(new Note("源自:web UI设计理论入门-网页是如何实现的", "web 标准化布局原理\n" +
                "把网页看成多个网格\n" +
                "先有行再有列（从上到下）\n" +
                "先做容器再做内容（从外到内）", "2017-07-10"));
        mList.add(new Note("源自:web UI设计理论入门-关于分辨率", "分辨率：水平和垂直像素个数", "2017-07-09"));
        mList.add(new Note("源自:web UI设计理论入门-webUI是什么", "UI的3个方向：\n" +
                "1.用户研究\n" +
                "2.交互设计\n" +
                "3.界面设计", "2017-07-08"));
        mList.add(new Note("源自:web UI设计理论入门-课程介绍", "ie9+、chrome、flex及主流浏览器都可兼容css3", "2017-07-07"));
        mList.add(new Note("源自:web UI设计理论入门-课程介绍", "ps里面有切片工具可以用来切图", "2017-07-07"));
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_note);
        mLinearLayoutManager = new LinearLayoutManager(this);
        NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(this, mList);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(noteRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            startActivity(new Intent(this, SearchActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
