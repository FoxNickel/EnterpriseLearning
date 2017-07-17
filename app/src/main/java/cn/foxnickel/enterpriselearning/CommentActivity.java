package cn.foxnickel.enterpriselearning;

import android.content.Intent;
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
import android.widget.Button;

import cn.foxnickel.enterpriselearning.adapter.CommentAdapter;

/**
 * Created by Night on 2017/7/16.
 * Desc:
 */

public class CommentActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycler_view_note;
    private SwipeRefreshLayout swipe_refresh;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        recycler_view_note = (RecyclerView) findViewById(R.id.recycler_view_note);
        swipe_refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        button = (Button) findViewById(R.id.bt_write_reply);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        CommentAdapter commentAdapter = new CommentAdapter(this);
        recycler_view_note.setLayoutManager(linearLayoutManager);
        recycler_view_note.setAdapter(commentAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommentActivity.this, WriteCommentActivity.class));
            }
        });
    }


}
