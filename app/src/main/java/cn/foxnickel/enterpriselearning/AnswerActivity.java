package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static cn.foxnickel.enterpriselearning.R.id.et_answer;

/**
 * Created by Night on 2017/7/16.
 * Desc:
 */

public class AnswerActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private EditText mEtAnswer;
    private TextInputLayout mTiAnswer;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
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
        mEtAnswer = (EditText) findViewById(et_answer);
        mButton = (Button) findViewById(R.id.bt_write_reply);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_write_reply:

                break;
            default:
                break;
        }
    }

}
