package cn.foxnickel.enterpriselearning;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.foxnickel.enterpriselearning.bean.Issue;
import cn.foxnickel.enterpriselearning.config.Config;

/**
 * Created by Night on 2017/7/19.
 * Desc:
 */

public class ExamAnalysisActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvExamName;
    private TextView mTvYourAnswer;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private TextView mTvExamScore;
    private RelativeLayout mRlIssueType;
    private EmphasisTextView mQuestionName;
    private TextView mTvRightAnswer;
    private LinearLayout mLlAnswer;
    private TextView mTvAnalysis;
    private Button mBtLastQuestion;
    private Button mBtNextQuestion;
    private ImageView[] ivOptions;
    private TextView[] tvOptions;
    private LinearLayout[] lloptions;
    private SparseArrayCompat<Integer> mIvSparseArray;
    private SparseArrayCompat<String> mAnswerArray;
    private int current = 0;
    //记录多选选项
    private int[] selectIds;
    private List<Issue> mIssueList;
    int grade;
    private float lastX, x, lastY, y, startX, endX, s0, e0, s1, e1, s2, e2;

    private ConstraintLayout mClExam;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_analysis);
        initView();
        startTest(0);
    }

    private void initView() {
        mScrollView = (ScrollView) findViewById(R.id.sv_exam);

        String strJson = Config.sSp.getString("issueList", null);
        Gson gson = new Gson();
        mIssueList = gson.fromJson(strJson, new TypeToken<List<Issue>>() {
        }.getType());
        mTvExamName = (TextView) findViewById(R.id.tv_exam_name);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvYourAnswer = (TextView) findViewById(R.id.tv_your_answer);
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
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mTvExamScore = (TextView) findViewById(R.id.tv_exam_score);
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
        mTvRightAnswer = (TextView) findViewById(R.id.tv_right_answer);
        mLlAnswer = (LinearLayout) findViewById(R.id.ll_answer);
        mTvAnalysis = (TextView) findViewById(R.id.tv_analysis);
        mBtLastQuestion = (Button) findViewById(R.id.bt_last_question);
        mBtNextQuestion = (Button) findViewById(R.id.bt_next_question);
        grade = Config.sSp.getInt("grade", 0);
        mTvExamScore.setText(grade + "分");
        //初始化多选数组
        selectIds = new int[]{-1, -1, -1, -1};
        mIvSparseArray = new SparseArrayCompat<>();
        mAnswerArray = new SparseArrayCompat<>();
        mAnswerArray.put(1, "A");
        mAnswerArray.put(2, "B");
        mAnswerArray.put(3, "C");
        mAnswerArray.put(4, "D");

        mIvSparseArray = new SparseArrayCompat<>();
        mIvSparseArray.put(0, R.drawable.ic_a_gray);
        mIvSparseArray.put(1, R.drawable.ic_b_gray);
        mIvSparseArray.put(2, R.drawable.ic_c_gray);
        mIvSparseArray.put(3, R.drawable.ic_d_gray);
        mIvSparseArray.put(4, R.drawable.ic_a_red);
        mIvSparseArray.put(5, R.drawable.ic_b_red);
        mIvSparseArray.put(6, R.drawable.ic_c_red);
        mIvSparseArray.put(7, R.drawable.ic_d_red);
        mIvSparseArray.put(8, R.drawable.ic_a_rec_gray);
        mIvSparseArray.put(9, R.drawable.ic_b_rec_gray);
        mIvSparseArray.put(10, R.drawable.ic_c_rec_gray);
        mIvSparseArray.put(11, R.drawable.ic_d_rec_gray);
        mIvSparseArray.put(12, R.drawable.ic_a_rec_red);
        mIvSparseArray.put(13, R.drawable.ic_b_rec_red);
        mIvSparseArray.put(14, R.drawable.ic_c_rec_red);
        mIvSparseArray.put(15, R.drawable.ic_d_rec_red);
        mBtLastQuestion.setOnClickListener(this);
        mBtNextQuestion.setOnClickListener(this);
        mClExam = (ConstraintLayout) findViewById(R.id.cl_exam);
        mClExam.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = event.getX();
                        lastY = event.getY();
                        startX = lastX;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = event.getX();
                        y = event.getY();
                        int offsetX = (int) (x - lastX);
                        int offsetY = (int) (y - lastY);
                        if ((mClExam.getBottom() + offsetY) <= mClExam.getWidth()) {
                            mClExam.layout(mClExam.getLeft(), mClExam.getTop() + offsetY,
                                    mClExam.getRight(), mClExam.getBottom() + offsetY);
                            lastX = x;
                            lastY = y;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        Log.e("TAG", "come in");
                        if ((endX - startX) > 8) {
                            goPrevious();
                        } else if ((startX - endX) > 8) {
                            goNext();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

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
        }
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
        } else if (current == 0) {
            mBtLastQuestion.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 下一题
     */
    private void goNext() {
        if (current < mIssueList.size() - 1) {
            current++;
            if (current == mIssueList.size() - 1) {
                mBtNextQuestion.setVisibility(View.INVISIBLE);
            }
            if (mBtLastQuestion.getVisibility() == View.INVISIBLE) {
                mBtLastQuestion.setVisibility(View.VISIBLE);
            }
            startTest(current);
            //初始化多选数组，可优化
            selectIds = mIssueList.get(current).getSelectedIds();
        }
    }

    private void startTest(int current) {
        Issue question = mIssueList.get(current);

        if (question.getType() == 0) {
            mTvRightAnswer.setText(mAnswerArray.get(Integer.parseInt(question.getRight())));
            if (question.isRight()) {
                mTvYourAnswer.setTextColor(Color.GREEN);
            } else {
                mTvYourAnswer.setTextColor(Color.RED);
            }
            mTvYourAnswer.setText(mAnswerArray.get(question.getSelectedId() + 1));

            mQuestionName.setText("（单选题）" + question.getQuestion());
            mQuestionName.setTextToHighlight("（单选题）");
            tvOptions[0].setText(question.getAnswerA());
            tvOptions[1].setText(question.getAnswerB());
            tvOptions[2].setText(question.getAnswerC());
            tvOptions[3].setText(question.getAnswerD());
            //解决RadioButton的复用问题
            resetChecked(current);
        } else if (question.getType() == 1) {
            StringBuilder sb = new StringBuilder();
            for (int ids : question.getSelectedIds()) {
                if (ids != -1) {
                    sb.append(mAnswerArray.get(ids + 1));
                }
            }
            if (question.isRight()) {
                mTvYourAnswer.setTextColor(Color.GREEN);
            } else {
                mTvYourAnswer.setTextColor(Color.RED);
            }
            mTvYourAnswer.setText(sb);
            sb = new StringBuilder();
            String s = question.getRight().trim();
            char[] c = s.toCharArray();
            for (char c1 : c) {
                sb.append((char) ('A' + c1 - '1'));
            }
            mTvRightAnswer.setText(sb);
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
        mTvAnalysis.setText("解析\n" + question.getAnalysis());
    }

    private void resetCheckeds(int position) {
        for (int i = 0; i < 4; i++) {
            ivOptions[i].setImageResource(mIvSparseArray.get(i + 8));
        }
        Log.e("TAG", "checkeds come in");
        Issue question = mIssueList.get(position);
        for (int selectedId : question.getSelectedIds()) {
            if (selectedId != -1) {
                ivOptions[selectedId].setImageResource(mIvSparseArray.get(selectedId + 12));
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

    private int getDeviceDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(
                Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return (int) metrics.density;
    }
}
