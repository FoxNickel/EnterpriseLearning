package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.HistoryRecyclerAdapter;

public class HistoryActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<String> mDateList;
    private List<List<String>> mCourseNameList;
    private List<List<String>> mChapterNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mDateList = new ArrayList<>();
        mDateList.add("今天");
        mDateList.add("昨天");
        mDateList.add("2017-07-25");
        mDateList.add("2017-07-24");

        /*课程名*/
        mCourseNameList = new ArrayList<>();
        /*今天*/
        List<String> mCourseName = new ArrayList<>();
        mCourseName.add("Java-从入门到精通");
        mCourseName.add("C-从入门到精通");
        mCourseName.add("Python-从入门到精通");
        mCourseNameList.add(mCourseName);

        /*昨天*/
        List<String> mCourseName1 = new ArrayList<>();
        mCourseName1.add("暗光高清拍摄技术");
        mCourseNameList.add(mCourseName1);

        /*7.25*/
        List<String> mCourseName2 = new ArrayList<>();
        mCourseName2.add("Java-从入门到精通");
        mCourseName2.add("C-从入门到精通");
        mCourseNameList.add(mCourseName2);

        /*7.24*/
        List<String> mCourseName3 = new ArrayList<>();
        mCourseName3.add("Java-从入门到精通");
        mCourseName3.add("C-从入门到精通");
        mCourseName3.add("Python-从入门到精通");
        mCourseName3.add("Python-从入门到精通");
        mCourseNameList.add(mCourseName3);

        /*章节名*/
        mChapterNameList = new ArrayList<>();

        /*今天*/
        List<String> mChapterName = new ArrayList<>();
        mChapterName.add("Java表达式");
        mChapterName.add("C语言标识符");
        mChapterName.add("Python逻辑运算");
        mChapterNameList.add(mChapterName);

        /*昨天*/
        List<String> mChapterName1 = new ArrayList<>();
        mChapterName1.add("暗光高清拍摄技术入门");
        mChapterNameList.add(mChapterName1);

        /*7.25*/
        List<String> mChapterName2 = new ArrayList<>();
        mChapterName2.add("Java表达式");
        mChapterName2.add("C表达式");
        mChapterNameList.add(mChapterName2);

        /*7.24*/
        List<String> mChapterName3 = new ArrayList<>();
        mChapterName3.add("Java表达式");
        mChapterName3.add("C表达式");
        mChapterName3.add("Python表达式");
        mChapterName3.add("Python表达式");
        mChapterNameList.add(mChapterName3);


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

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_history);
        mLinearLayoutManager = new LinearLayoutManager(this);
        HistoryRecyclerAdapter historyRecyclerAdapter = new HistoryRecyclerAdapter(this, mDateList, mCourseNameList, mChapterNameList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(historyRecyclerAdapter);
    }
}
