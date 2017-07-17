package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.SpecificPlanRecyclerAdapter;

/**
 * Created by Night on 2017/7/11.
 * Desc:
 */

public class SpecificPlanActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mExamSwipeRefresh;
    private SpecificPlanRecyclerAdapter mSpecificPlanRecyclerAdapter;
    private Toolbar mToolbar;
    private TextView mTvPlanName;
    private List<String> planStage;
    private List<List<String>> planStageNode;
    private Button mBtSignUp;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SpecificPlanActivity.this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mTvPlanName = (TextView) findViewById(R.id.tv_plan_name);
        String s = getIntent().getStringExtra("planname").replace("\n", " ");
        mTvPlanName.setText(s);
        planStage = new ArrayList<String>();
        planStageNode = new ArrayList<List<String>>();

        planStage.add("第一阶段：公司介绍");
        List<String> list = new ArrayList<>();
        list.add("课时1:公司发展简介");
        list.add("课时2:公司管理制度 ");
        list.add("课时3:公司人力资源制度");
        list.add("课时4:公司企业文化");
        planStageNode.add(list);

        planStage.add("第二阶段：专业知识培训");
        list = new ArrayList<>();
        list.add("课时1:公司代码规范");
        list.add("课时2:代码整洁之道");
        list.add("课时3:如何提升开发效率");
        planStageNode.add(list);

        planStage.add("第三阶段：专业技能考核");
        list = new ArrayList<>();
        list.add("培训考核");
        planStageNode.add(list);

        mSpecificPlanRecyclerAdapter = new SpecificPlanRecyclerAdapter(SpecificPlanActivity.this, planStage, planStageNode);
        mRecyclerView.setAdapter(mSpecificPlanRecyclerAdapter);

        mBtSignUp = (Button) findViewById(R.id.bt_sign_up);
        mBtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sign_up:
                startActivity(new Intent(this, PlayVideoActivity.class));
                v.setVisibility(View.GONE);
                break;
        }
    }
}
