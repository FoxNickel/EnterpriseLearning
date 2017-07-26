package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.config.Config;

/**
 * Created by Night on 2017/7/18.
 * Desc:
 */

public class ExamActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTvExamName;
    private TextView mTvExamState;
    private TextView mTvExamStartTime;
    private TextView mTvExamEndTime;
    private TextView mTvExamDuration;
    private TextView mTvExamTotalScore;
    private TextView mTvExamPass;
    private TextView mTvExamCredit;
    private TextView mTvExamScore;
    private Button mBtStartExam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
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
        mTvExamName = (TextView) findViewById(R.id.tv_exam_name);
        mTvExamState = (TextView) findViewById(R.id.tv_exam_state);
        mTvExamStartTime = (TextView) findViewById(R.id.tv_exam_start_time);
        mTvExamEndTime = (TextView) findViewById(R.id.tv_exam_end_time);
        mTvExamDuration = (TextView) findViewById(R.id.tv_exam_duration);
        mTvExamTotalScore = (TextView) findViewById(R.id.tv_exam_total_score);
        mTvExamPass = (TextView) findViewById(R.id.tv_exam_pass);
        mTvExamCredit = (TextView) findViewById(R.id.tv_exam_credit);
        mTvExamScore = (TextView) findViewById(R.id.tv_exam_score);
        mBtStartExam = (Button) findViewById(R.id.bt_start_exam);
        final int grade = Config.sSp.getInt("grade", -1);
        if (grade != -1) {
            mBtStartExam.setText("查看答案");
            mTvExamScore.setText(grade + "分");
            mTvExamState.setText("已完成");
        }
        mBtStartExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grade == -1)
                    startActivity(new Intent(ExamActivity.this, SpecificExamActivity.class));
                else
                    startActivity(new Intent(ExamActivity.this, ExamAnalysisActivity.class));

            }
        });
    }


}
