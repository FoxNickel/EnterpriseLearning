package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TrainingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    /**
     * 这是培训名称
     */
    private TextView mTvTrainingName;
    private ImageView mImageView;
    /**
     * 这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍
     */
    private TextView mTvIntro;
    /**
     * 报名人数：36人
     */
    private TextView mTvNum;
    /**
     * 培训地点：二楼会议室
     */
    private TextView mTvPlace;
    /**
     * 开始时间：2017年7月7日 12：00
     */
    private TextView mTvStartTime;
    /**
     * 培训时长：2小时
     */
    private TextView mTvDuration;
    /**
     * 点击下载
     */
    private TextView mTvDownload;
    /**
     * 我要报名
     */
    private Button mBtSignUp;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_detail);
        mIntent = getIntent();
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

        mTvTrainingName = (TextView) findViewById(R.id.tv_training_name);
        mTvTrainingName.setText(mIntent.getStringExtra("training_name"));
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTvIntro = (TextView) findViewById(R.id.tv_intro);
        mTvIntro.setText(mIntent.getStringExtra("training_intro"));
        mTvNum = (TextView) findViewById(R.id.tv_num);
        mTvNum.setText(mIntent.getStringExtra("training_num"));
        mTvPlace = (TextView) findViewById(R.id.tv_place);
        mTvPlace.setText(mIntent.getStringExtra("training_place"));
        mTvStartTime = (TextView) findViewById(R.id.tv_start_time);
        mTvStartTime.setText(mIntent.getStringExtra("training_start_time"));
        mTvDuration = (TextView) findViewById(R.id.tv_duration);
        mTvDuration.setText(mIntent.getStringExtra("training_duration"));
        mTvDownload = (TextView) findViewById(R.id.tv_download);
        mTvDownload.setOnClickListener(this);
        mBtSignUp = (Button) findViewById(R.id.bt_sign_up);
        mBtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_download:
                break;
            case R.id.bt_sign_up:
                break;
        }
    }
}
