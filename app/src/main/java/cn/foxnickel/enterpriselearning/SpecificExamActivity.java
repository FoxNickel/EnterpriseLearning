package cn.foxnickel.enterpriselearning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.bean.Exam;
import cn.foxnickel.enterpriselearning.bean.Issue;
import cn.foxnickel.enterpriselearning.config.Config;

/**
 * Created by Night on 2017/7/19.
 * Desc:Specific Exam Activity
 */

public class SpecificExamActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView[] ivOptions;
    private TextView[] tvOptions;
    private LinearLayout[] lloptions;
    private Chronometer mCtCountTime;
    private Toolbar mToolbar;
    private TextView mQuestiobCount;
    private RelativeLayout mRlIssueType;
    private EmphasisTextView mQuestionName;
    public static List<Issue> mIssueList;
    int miss = 3600;//考试时间
    //当前题目指针
    private int current = 0;
    private Button mBtLastQuestion;
    private Button mBtNextQuestion;
    public static Exam mExam;
    private TextView mTvExamName;
    //记录多选选项
    private int[] selectIds;
    private SparseArrayCompat<Integer> mIvSparseArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_details);
        initView();
    }

    private void initView() {
        mCtCountTime = (Chronometer) findViewById(R.id.ct_count_time);
        mCtCountTime.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                mCtCountTime.setText(FormatMiss());
            }
        });
        mIvSparseArray = new SparseArrayCompat<>();
        mIvSparseArray.put(0, R.drawable.ic_a_gray);
        mIvSparseArray.put(1, R.drawable.ic_b_gray);
        mIvSparseArray.put(2, R.drawable.ic_c_gray);
        mIvSparseArray.put(3, R.drawable.ic_d_gray);
        mIvSparseArray.put(4, R.drawable.ic_a_red);
        mIvSparseArray.put(5, R.drawable.ic_b_red);
        mIvSparseArray.put(6, R.drawable.ic_c_red);
        mIvSparseArray.put(7, R.drawable.ic_d_red);
        mCtCountTime.start();
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
        mQuestiobCount = (TextView) findViewById(R.id.tv_question_count);
        mRlIssueType = (RelativeLayout) findViewById(R.id.rl_issue_type);
        mQuestionName = (EmphasisTextView) findViewById(R.id.emphasisTextView);
        ivOptions = new ImageView[4];
        tvOptions = new TextView[4];
        lloptions = new LinearLayout[4];
        ivOptions[0] = (ImageView) findViewById(R.id.iv_a);
        ivOptions[1] = (ImageView) findViewById(R.id.iv_b);
        ivOptions[2] = (ImageView) findViewById(R.id.iv_c);
        ivOptions[3] = (ImageView) findViewById(R.id.iv_d);
        tvOptions[0] = (TextView) findViewById(R.id.tv_a);
        tvOptions[1] = (TextView) findViewById(R.id.tv_b);
        tvOptions[2] = (TextView) findViewById(R.id.tv_c);
        tvOptions[3] = (TextView) findViewById(R.id.tv_d);
        lloptions[0] = (LinearLayout) findViewById(R.id.ll_a);
        lloptions[1] = (LinearLayout) findViewById(R.id.ll_b);
        lloptions[2] = (LinearLayout) findViewById(R.id.ll_c);
        lloptions[3] = (LinearLayout) findViewById(R.id.ll_d);

        for (int i = 0; i < lloptions.length; i++) {
            final int a = i;
            lloptions[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            for (int j = 0; j < lloptions.length; j++) {
                                ivOptions[j].setImageResource(mIvSparseArray.get(j));
                            }
                            ivOptions[a].setImageResource(mIvSparseArray.get(a + 4));
                            break;
                        case MotionEvent.ACTION_UP:
                            ivOptions[a].setImageResource(mIvSparseArray.get(a));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
            tvOptions[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            for (int j = 0; j < lloptions.length; j++) {
                                ivOptions[j].setImageResource(mIvSparseArray.get(j));
                            }
                            ivOptions[a].setImageResource(mIvSparseArray.get(a + 4));
                            break;
                        case MotionEvent.ACTION_UP:
                            ivOptions[a].setImageResource(mIvSparseArray.get(a));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
            ivOptions[i].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            for (int j = 0; j < lloptions.length; j++) {
                                ivOptions[j].setImageResource(mIvSparseArray.get(j));
                            }
                            ivOptions[a].setImageResource(mIvSparseArray.get(a + 4));
                            break;
                        case MotionEvent.ACTION_UP:
                            ivOptions[a].setImageResource(mIvSparseArray.get(a));
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }
        for (ImageView ivOption : ivOptions) {
            ivOption.setOnClickListener(this);
        }
        for (TextView tvOption : tvOptions) {
            tvOption.setOnClickListener(this);
        }
        for (LinearLayout lloption : lloptions) {
            lloption.setOnClickListener(this);
        }
        mBtLastQuestion = (Button) findViewById(R.id.bt_last_question);
        mBtLastQuestion.setOnClickListener(this);
        mBtNextQuestion = (Button) findViewById(R.id.bt_next_question);
        mBtNextQuestion.setOnClickListener(this);
        mTvExamName = (TextView) findViewById(R.id.tv_exam_name);

        dataInit();
        mTvExamName.setText(mExam.getExamName());
        startTest(0);

    }

    private void dataInit() {
        //初始化多选数组
        selectIds = new int[]{-1, -1, -1, -1};
        mExam = new Exam();
        mExam.setExamName("新员工入职考试");
        mExam.setExamLimit(3600);
        mExam.setExaming(false);
        mIssueList = new ArrayList<>();
        Issue issue = new Issue();
        issue.setQuestion("关于数据解析下列说法正确的是：");
        issue.setType(0);
        issue.setAnswerA("XML数据结构有且只有一个根节点，并且不能嵌套");
        issue.setAnswerB("JSONObjetWithData:options:error:使用文件流");
        issue.setAnswerC("writeJSONObject:toStream:options:error:使用缓冲区数据解析json");
        issue.setAnswerD("XML解析分为两种：SAX解析和DOM解析");
        issue.setAnalysis("A、XML只能有一个根节点，但是可以嵌套\n" +
                "B、JSONObjetWithData:options:error:使用缓冲区数据来解析\n" +
                "C、writeJSONObject:toStream:options:error:使用流来解析");
        issue.setRight("4");
        mIssueList.add(issue);
        issue = new Issue();
        issue.setQuestion("大小为MAX的循环队列中，f为当前对头元素位置，r为当前队尾元素位置(最后一个元素的位置)，则任意时刻，队列中的元素个数为");
        issue.setType(0);
        issue.setAnswerA("r-f");
        issue.setAnswerB("(r-f+MAX+1)%MAX");
        issue.setAnswerC("r-f+1");
        issue.setAnswerD("(r-f+MAX)%MAX");
        issue.setAnalysis("首先凭着记忆肯定是B、D中的一个，然后随便找个例子验证一下就能选出是B。");
        issue.setRight("2");
        mIssueList.add(issue);
        issue = new Issue();
        issue.setQuestion("已知两个一维模式类别的类概率密度函数为:\n" +
                "先验概率P(1)=0.6,P(2)=0.4,则样本{x1=1.35,x2=1.45,x3=1.55,x4=1.65}各属于哪一类别?");
        issue.setType(1);
        issue.setAnswerA("XML数据结构有且只有一个根节点，并且不能嵌套");
        issue.setAnswerB("JSONObjetWithData:options:error:使用文件流");
        issue.setAnswerC("writeJSONObject:toStream:options:error:使用缓冲区数据解析json");
        issue.setAnswerD("XML解析分为两种：SAX解析和DOM解析");
        issue.setAnalysis("比较后验概率p(w|x)，哪个类的后验概率大，就属于哪个类\n" +
                "后验概率：p(w|x)=p(x|w)p(w)/p(x)，分母p(x)总是常数可以忽略，先验概率p(w)已知，计算类条件概率p(x|w)，即可得到后验概率\n" +
                "在算x1=1.35时，p(w1|x1)=p(x1|w1)*p(w1)/p(x1) = (2-1.35)*0.6/p(x1)=0.39/p(x1)\n" +
                "p(w2|x1)=p(x1|w2)*p(w2)/p(x1)=(1.35-1)*0.4/p(x1)=0.14/p(x1)\n" +
                "所以p(w1|x1) > p(w2|x1)，所以x1属于w1类\n" +
                "同理可以算出其他的。");

        issue.setRight("1234");
        mIssueList.add(issue);
        issue = new Issue();
        issue.setQuestion("程序员小李通过管道统计prog.c函数中for语句通过的次数，需要使用的指令分别是");
        issue.setType(1);
        issue.setAnswerA("vi");
        issue.setAnswerB("grep");
        issue.setAnswerC("wc");
        issue.setAnswerD("sort");
        issue.setAnalysis("使用的命令： grep “for” proc.c | wc –l\n" +
                "grep, GlobalRegular Expression Print，使用正则表达式搜索文本，并把匹配的行打印出来\n" +
                "wc, word count，统计指定文件中的字节数，字数，行数，并将统计结果显示输出。如果没有给出文件名，则从标准输入读取，wc同时也给出所指定文件的总统计数。命令参数：-c 统计字节数。-l 统计行数。-m统计字符数\n" +
                "可以使用vi编辑器编辑现有的文件，也可以创建一个新文件，还能以只读模式打开文本文件。\n" +
                "sort将文件的每一行作为一个单位，相互比较，比较原则是从首字符向后，依次按ASCII码值进行比较，最后将他们按升序输出。");
        issue.setRight("23");
        mIssueList.add(issue);
    }

    private String FormatMiss() {
        miss--;
        String hh = miss / 3600 > 9 ? miss / 3600 + "" : "0" + miss / 3600;
        String mm = (miss % 3600) / 60 > 9 ? (miss % 3600) / 60 + "" : "0" + (miss % 3600) / 60;
        String ss = (miss % 3600) % 60 > 9 ? (miss % 3600) % 60 + "" : "0" + (miss % 3600) % 60;
        return hh + ":" + mm + ":" + ss;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_last_question:
                goPrevious();
                break;
            case R.id.bt_next_question:
                goNext();
                break;
            case R.id.ll_a:
            case R.id.iv_a:
            case R.id.tv_a:
                if (selectIds[0] == 0) {
                    selectIds[0] = -1;
                } else {
                    selectIds[0] = 0;
                }
                selectChecked(current, 0, selectIds);
                break;
            case R.id.ll_b:
            case R.id.iv_b:
            case R.id.tv_b:
                if (selectIds[1] == 1) {
                    selectIds[1] = -1;
                } else {
                    selectIds[1] = 1;
                }
                selectChecked(current, 1, selectIds);
                break;
            case R.id.ll_c:
            case R.id.iv_c:
            case R.id.tv_c:
                if (selectIds[2] == 2) {
                    selectIds[2] = -1;
                } else {
                    selectIds[2] = 2;
                }
                selectChecked(current, 2, selectIds);
                break;
            case R.id.ll_d:
            case R.id.iv_d:
            case R.id.tv_d:
                if (selectIds[3] == 3) {
                    selectIds[3] = -1;
                } else {
                    selectIds[3] = 3;
                }
                selectChecked(current, 3, selectIds);
                break;
        }
    }

    private void selectChecked(int current, int selectId, int[] selectIds) {
        Issue question = mIssueList.get(current);
        if (question.getType() == 0) {
            setChecked(current, selectId);
        } else if (question.getType() == 1) {
            setCheckeds(current, selectIds);
        }
    }

    private void setCheckeds(int position, int[] selectIds) {
        Issue question = mIssueList.get(position);
        question.setSelectedIds(selectIds);
        resetCheckeds(position);
    }

    private void setChecked(int position, int selectId) {
        Issue question = mIssueList.get(position);
        question.setSelectedId(selectId);
        resetChecked(position);
    }

    /**
     * 上一题
     */
    private void goPrevious() {
        if (current > 0) {
            if (mBtNextQuestion.getVisibility() == View.INVISIBLE) {
                mBtNextQuestion.setVisibility(View.VISIBLE);
            }
            current--;
            if (current == 0) {
                mBtLastQuestion.setVisibility(View.INVISIBLE);
            }
            startTest(current);
            //初始化多选数组，可优化
            selectIds = mIssueList.get(current).getSelectedIds();
        }
        //题目计数器
        mQuestiobCount.setText((current + 1) + "/" + mIssueList.size());
    }

    /**
     * 下一题
     */
    private void goNext() {
        if (current < mIssueList.size() - 1) {
            current++;
            if (mBtLastQuestion.getVisibility() == View.INVISIBLE) {
                mBtLastQuestion.setVisibility(View.VISIBLE);
            }
            startTest(current);
            //初始化多选数组，可优化
            selectIds = mIssueList.get(current).getSelectedIds();
        } else if (current == mIssueList.size() - 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("答题完成")
                    .setMessage("确定要上交题目吗？")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            endTest();
                        }
                    }).show();

        }
        //题目计数器
        mQuestiobCount.setText((current + 1) + "/" + mIssueList.size());

    }

    int grade = 0;

    private void endTest() {
        //计算分数
        for (Issue q : mIssueList) {
            if (q.getType() == 0) {
                if (q.getRight().equals("" + (q.getSelectedId() + 1))) {
                    grade++;
                    mIssueList.get(mIssueList.indexOf(q)).setRight(true);
                } else {
                    mIssueList.get(mIssueList.indexOf(q)).setRight(false);
                }
            } else if (q.getType() == 1) {
                StringBuilder sb = new StringBuilder();
                for (int ids : q.getSelectedIds()) {
                    if (ids != -1) {
                        sb.append(ids + 1);
                    }
                }
                if (sb.toString().equals(q.getRight())) {
                    grade++;
                    mIssueList.get(mIssueList.indexOf(q)).setRight(true);
                } else {
                    mIssueList.get(mIssueList.indexOf(q)).setRight(false);
                }
            }
        }
        mExam.setGrade((int) (grade * 1.0 / mIssueList.size() * 100));
        finish();
        Config.setDataList("issueList", mIssueList);
        SharedPreferences.Editor editor = Config.sSp.edit();
        editor.putInt("grade", (int) (grade * 1.0 / mIssueList.size() * 100));
        editor.apply();
        startActivity(new Intent(this, ExamAnalysisActivity.class));
    }

    private void startTest(int current) {
        Issue question = mIssueList.get(current);
        if (question.getType() == 0) {
            mQuestionName.setText("（单选题）" + question.getQuestion());
            mQuestionName.setTextToHighlight("（单选题）");
            tvOptions[0].setText(question.getAnswerA());
            tvOptions[1].setText(question.getAnswerB());
            tvOptions[2].setText(question.getAnswerC());
            tvOptions[3].setText(question.getAnswerD());
            //解决RadioButton的复用问题
            resetChecked(current);
        } else if (question.getType() == 1) {
            mQuestionName.setText("（多选题）" + question.getQuestion());
            mQuestionName.setTextToHighlight("（多选题）");
            tvOptions[0].setText(question.getAnswerA());
            tvOptions[1].setText(question.getAnswerB());
            tvOptions[2].setText(question.getAnswerC());
            tvOptions[3].setText(question.getAnswerD());
            //解决RadioButton的复用问题
            resetCheckeds(current);
        }
        mQuestionName.setTextHighlightColor(R.color.colorPrimary);
        mQuestionName.setHighlightMode(HighlightMode.TEXT);
        mQuestionName.highlight();
    }

    private void resetCheckeds(int position) {
        for (int i = 0; i < ivOptions.length; i++) {
            ivOptions[i].setImageResource(mIvSparseArray.get(i));
        }

        Issue question = mIssueList.get(position);
        for (int selectedId : question.getSelectedIds()) {
            if (selectedId != -1) {
                ivOptions[selectedId].setImageResource(mIvSparseArray.get(selectedId + 4));
            }
        }
    }

    private void resetChecked(int position) {
        for (int i = 0; i < ivOptions.length; i++) {
            ivOptions[i].setImageResource(mIvSparseArray.get(i));
        }

        Issue question = mIssueList.get(position);
        int selectedId = question.getSelectedId();
        if (selectedId != -1) {
            ivOptions[selectedId].setImageResource(mIvSparseArray.get(selectedId + 4));
        }

    }
}
