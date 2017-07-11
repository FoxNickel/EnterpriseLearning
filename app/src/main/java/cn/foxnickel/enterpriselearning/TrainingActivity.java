package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.foxnickel.enterpriselearning.adapter.TrainingRecyclerAdapter;

public class TrainingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewTraining;
    private SwipeRefreshLayout mSwipeRefresh;
    private LinearLayoutManager mLinearLayoutManager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        initView();
    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        mRecyclerViewTraining = (RecyclerView) findViewById(R.id.recycler_view_training);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        mLinearLayoutManager = new LinearLayoutManager(this);
        TrainingRecyclerAdapter trainingRecyclerAdapter = new TrainingRecyclerAdapter(this);

        mRecyclerViewTraining.setLayoutManager(mLinearLayoutManager);
        mRecyclerViewTraining.setAdapter(trainingRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
