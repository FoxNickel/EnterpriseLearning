package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Night on 2017/7/28.
 * Desc:
 */

public class WriteNoteActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText mEtWriteReply;
    private Button mBtRelease;
    private TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_comment);
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
        mEtWriteReply = (EditText) findViewById(R.id.et_write_reply);
        mEtWriteReply.setHint("请输入笔记内容");
        mBtRelease = (Button) findViewById(R.id.bt_release);
        mBtRelease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WriteNoteActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
            }
        });
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText("记笔记");
    }


}
