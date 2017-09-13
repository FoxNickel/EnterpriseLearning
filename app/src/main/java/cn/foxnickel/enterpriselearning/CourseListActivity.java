package cn.foxnickel.enterpriselearning;

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
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.CourseListRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Chapter;
import cn.foxnickel.enterpriselearning.bean.Course;
import cn.foxnickel.enterpriselearning.bean.Note;
import cn.foxnickel.enterpriselearning.utils.Resources;

/**
 * Created by Night on 2017/7/15.
 * Desc:Course List Activity
 */

public class CourseListActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Toolbar mToolbar;
    private TextView mTvCourseCount;
    private Spinner mSpinner2;
    private Spinner mSpinner;
    private RecyclerView mRecyclerViewNote;
    private SwipeRefreshLayout mSwipeRefresh;
    private List<Course> mCourseList;
    private CourseListRecyclerAdapter mCourseListRecyclerAdapter;
    boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
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

    Course kotlinCourse, testCourse;

    private void initView() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        String title = getIntent().getStringExtra("title");
        mTvTitle.setText(title);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvCourseCount = (TextView) findViewById(R.id.tv_course_count);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mRecyclerViewNote = (RecyclerView) findViewById(R.id.recycler_view_note);
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewNote.setLayoutManager(linearLayoutManager);
        mCourseList = new ArrayList<>();
        switch (title) {
            case "Android":
                flag = true;
                List<Chapter> chapters = new ArrayList<>();
                List<Note> notes = new ArrayList<>();
                chapters.add(new Chapter("第1章 自动化基础篇", true, null, ""));
                chapters.add(new Chapter("1-1 自动化预备知识（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-2 自动化预备知识（下）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-3 电池续航自动化测试(上) ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-4 电池续航自动化测试(下) ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-5 MonkeyRunner原理初步 ", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 自动化提高篇", true, null, ""));
                chapters.add(new Chapter("2-1 instrumentation框架（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 instrumentation框架（下）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 截图原理深入分析（上）", false, Resources.VIDEO, "http://120.221.64.130/video.study.163.com/edu-video/nos/mp4/2014/07/12/507153_sd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee97c0cef09cb96fd615c0ac81c0f778663cc7cec1931216ab165d9b2137031d1920d04103874421dce5cd7bbabbfc3c2284a1c46e13dea4037cf2150b0ef7e0e2493d3b07147c2ace70d66e57880ba1a7237b1f1b474d469b8af3e6ce54f580b31651daa307f794c4c0f7b7fe70a9ca043606e7af4345d9a11bc4fc0505d12bf6976386d60da86b917348b1a6565e9523e13094dfa9acdeeffa795d972f220604&wshc_tag=0&wsts_tag=59b6b27e&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-4 截图原理深入分析（下）", false, Resources.VIDEO, ""));
                notes.add(new Note("源自:Android自动化测试-自动化预备知识（上）",
                        "Robotium基于控件的自动化框架，遇到不支持的控件使用点击坐标点方法", "2017-07-10"));
                notes.add(new Note("源自:Android自动化测试-自动化预备知识（上）", "1、如何测试分布式ATM机？\n" +
                        "2、如何用数组实现三个堆站，要求有效的使用数据的存储空间，可以使用其他的数据结构\n" +
                        "3、编写一个脚本，统计log文件中首歌单词出现的次数，如error:xxx", "2017-07-09"));

                testCourse = new Course("Android自动化测试", chapters, 2, "自动化测试永远是软件测试的热点，企业总希望通过测试自动化大幅降低测试工作的成本。到底如何实施自动化测试?自动化测试框架如何使用?这些既是热点问题，也是难点!"
                        , "本课程是Android自动化测试的系统课程"
                        , "1、教你掌握自动化测试技术、工具和框架\n"
                        + "2、明白掌握自动化测试脚本的编写和阅读\n"
                        , notes);
                testCourse.setCourseStars(4);
                mCourseList.add(testCourse);
                chapters.clear();
                notes.clear();
                chapters.add(new Chapter("第1章 初识kotlin", true, null, ""));
                chapters.add(new Chapter("1-1 kotlin选好教练车", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("1-2 kotlin你好世界", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("第2章 kotlin基本知识", true, null, ""));
                chapters.add(new Chapter("2-1 kotlin变量与输出", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-2 kotlin二进制基础", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-3 kotlin变量和常量", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));
                chapters.add(new Chapter("2-4 kotlin变量取值范围", false, Resources.VIDEO, "http://223.111.18.46/video.study.163.com/edu-video/nos/mp4/2017/08/17/1006760456_5343c7dd96524fbfb2e699090eac3e2d_shd.mp4?ak=99ed7479ee303d1b1361b0ee5a4abcee723c57f29189d94f20855dcfcebd7309a57ff4473bf4d914a17c202e18f8054b28724715ecded5e5baf51400a4e7dda9c5c2392413a096f94c1b700ffc15fb5490b601143824cf18b58a69ea00438816e2c4caba0e116581c14e4824cb46dc107feb6d0bf73a0d052df948b3525aefb09eed6bb2ffe8530b0f8655d97b53dc6197cbdc8f6a5d1563323094d2340ba3cf2919f5e4aded4ea11a82dd96c04efc1a&wshc_tag=0&wsts_tag=59b6b150&wsid_tag=700ab4b2&wsiphost=ipdbm"));

                kotlinCourse = new Course("kotlin从零基础到进阶", chapters, 2, "学习kotlin最好的时机是三年前,其次是现在.\n" +
                        "掌握kotlin可以开发 Web前端 Web后端 Android移动端 Server脚本 桌面游戏\n" +
                        "本套课程采用真实案例讲解, 拒绝纸上谈兵\n" +
                        "顺便带你复习高中物理、化学、生物和数学, 重新找回学霸的感觉"
                        , "本课程是kotlin的入门课程,需具备基础的\nJAVA知识"
                        , "1、学会kotlin基本语法知识\n"
                        + "2、掌握kotlin与JAVA的混合开发\n"
                        , notes);
                kotlinCourse.setCourseStars(5);
                mCourseList.add(kotlinCourse);
                break;
            case "HTML":
                flag = false;
                mCourseList.add(new Course("web UI设计理论入门", "", 3));
                mCourseList.add(new Course("UI设计小锦囊", "", 4));
                break;
            default:
                flag = false;
                mCourseList.add(new Course("web UI设计理论入门", "", 3));
                mCourseList.add(new Course("UI设计小锦囊", "", 4));

                break;

        }
        mCourseListRecyclerAdapter = new CourseListRecyclerAdapter(this, mCourseList);
        mRecyclerViewNote.setAdapter(mCourseListRecyclerAdapter);
        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mCourseList.clear();
                        if (!flag) {
                            mCourseList.add(new Course("web UI设计理论入门", "", 3));
                            mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        } else {
                            mCourseList.add(testCourse);
                            mCourseList.add(kotlinCourse);
                        }
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mCourseList.clear();
                        if (!flag) {
                            mCourseList.add(new Course("UI设计小锦囊", "", 4));
                            mCourseList.add(new Course("web UI设计理论入门", "", 3));
                        } else {
                            mCourseList.add(kotlinCourse);
                            mCourseList.add(testCourse);
                        }
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        Collections.sort(mCourseList);
                        Collections.reverse(mCourseList);
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mCourseList.clear();
                        if (!flag) {
                            mCourseList.add(new Course("web UI设计理论入门", "", 3));
                            mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        } else {
                            mCourseList.add(testCourse);
                            mCourseList.add(kotlinCourse);
                        }
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mCourseList.clear();
                        if (!flag) {
                            mCourseList.add(new Course("web UI设计理论入门", "", 3));
                            mCourseList.add(new Course("UI设计小锦囊", "", 4));
                        } else {
                            mCourseList.add(testCourse);
                            mCourseList.add(kotlinCourse);
                        }
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        mCourseList.clear();
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        mCourseList.clear();
                        mCourseListRecyclerAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
