package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class LearningDataActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BarChart mLearningTimeBarChart, mChapterCompleteBarChart, mScoreBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_data);
        initView();
        initTimeBarChart();
        initChapterBarChart();
        initScoreBarChart();
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

    }

    private void initTimeBarChart() {
        mLearningTimeBarChart = (BarChart) findViewById(R.id.chart_learning_time);

        mLearningTimeBarChart.setDrawGridBackground(false);
        mLearningTimeBarChart.setDrawBarShadow(false);
        mLearningTimeBarChart.setDrawValueAboveBar(true);
        mLearningTimeBarChart.getDescription().setEnabled(false);
        mLearningTimeBarChart.animateY(2000);

        /*2.获取坐标轴并进行设置*/
        //获取和设置X轴
        XAxis xAxis = mLearningTimeBarChart.getXAxis();//获取X轴
        xAxis.setEnabled(true);//设置显示X轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴位置
        xAxis.setAxisLineWidth(1);//设置X轴宽度
        xAxis.setDrawGridLines(false);//无网格
        xAxis.setDrawAxisLine(true);//显示X轴
        /*X轴数据*/
        final String[] xValues = {"3.14", "3.15", "3.16", "3.17", "3.18", "3.19", "3.20"};
        /*给X轴设置数据*/
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues[(int) value];
            }
        });
        xAxis.setDrawLabels(true);

        //获取并设置Y轴
        YAxis leftYAxis = mLearningTimeBarChart.getAxisLeft();//获取左侧Y轴
        YAxis rightYAxis = mLearningTimeBarChart.getAxisRight();//获取右侧Y轴
        rightYAxis.setEnabled(false);//禁止显示右侧Y轴
        leftYAxis.setAxisLineWidth(0);
        leftYAxis.setDrawGridLines(true);
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setDrawLabels(true);

        /*3.添加数据*/
        ArrayList<BarEntry> entries1 = new ArrayList<>();//Entry就是折线图上的点
        entries1.add(new BarEntry(0, 90));
        entries1.add(new BarEntry(1, 45));
        entries1.add(new BarEntry(2, 10));
        entries1.add(new BarEntry(3, 35));
        entries1.add(new BarEntry(4, 30));
        entries1.add(new BarEntry(5, 40));
        entries1.add(new BarEntry(6, 48));

        BarDataSet barDataSet = new BarDataSet(entries1, "学习时长");
        barDataSet.setColor(getResources().getColor(R.color.blue));

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        mLearningTimeBarChart.setData(barData);
        mLearningTimeBarChart.invalidate();//刷新显示

    }

    private void initChapterBarChart() {
        mChapterCompleteBarChart = (BarChart) findViewById(R.id.chart_chapter_complete);

        mChapterCompleteBarChart.setDrawGridBackground(false);
        mChapterCompleteBarChart.setDrawBarShadow(false);
        mChapterCompleteBarChart.setDrawValueAboveBar(true);
        mChapterCompleteBarChart.getDescription().setEnabled(false);
        mChapterCompleteBarChart.animateY(2000);

        /*2.获取坐标轴并进行设置*/
        //获取和设置X轴
        XAxis xAxis = mChapterCompleteBarChart.getXAxis();//获取X轴
        xAxis.setEnabled(true);//设置显示X轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴位置
        xAxis.setAxisLineWidth(1);//设置X轴宽度
        xAxis.setDrawGridLines(false);//无网格
        xAxis.setDrawAxisLine(true);//显示X轴
        /*X轴数据*/
        final String[] xValues = {"3.14", "3.15", "3.16", "3.17", "3.18", "3.19", "3.20"};
        /*给X轴设置数据*/
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues[(int) value];
            }
        });
        xAxis.setDrawLabels(true);

        //获取并设置Y轴
        YAxis leftYAxis = mChapterCompleteBarChart.getAxisLeft();//获取左侧Y轴
        YAxis rightYAxis = mChapterCompleteBarChart.getAxisRight();//获取右侧Y轴
        rightYAxis.setEnabled(false);//禁止显示右侧Y轴
        leftYAxis.setAxisLineWidth(0);
        leftYAxis.setDrawGridLines(true);
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setDrawLabels(true);

        /*3.添加数据*/
        ArrayList<BarEntry> entries1 = new ArrayList<>();//Entry就是折线图上的点
        entries1.add(new BarEntry(0, 10));
        entries1.add(new BarEntry(1, 5));
        entries1.add(new BarEntry(2, 1));
        entries1.add(new BarEntry(3, 3));
        entries1.add(new BarEntry(4, 2));
        entries1.add(new BarEntry(5, 4));
        entries1.add(new BarEntry(6, 6));

        BarDataSet barDataSet = new BarDataSet(entries1, "完成的小节数");
        barDataSet.setColor(getResources().getColor(R.color.orange));

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        mChapterCompleteBarChart.setData(barData);
        mChapterCompleteBarChart.invalidate();//刷新显示
    }

    private void initScoreBarChart() {
        mScoreBarChart = (BarChart) findViewById(R.id.chart_score);

        mScoreBarChart.setDrawGridBackground(false);
        mScoreBarChart.setDrawBarShadow(false);
        mScoreBarChart.setDrawValueAboveBar(true);
        mScoreBarChart.getDescription().setEnabled(false);
        mScoreBarChart.animateY(2000);

        /*2.获取坐标轴并进行设置*/
        //获取和设置X轴
        XAxis xAxis = mScoreBarChart.getXAxis();//获取X轴
        xAxis.setEnabled(true);//设置显示X轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴位置
        xAxis.setAxisLineWidth(1);//设置X轴宽度
        xAxis.setDrawGridLines(false);//无网格
        xAxis.setDrawAxisLine(true);//显示X轴
        /*X轴数据*/
        final String[] xValues = {"3.14", "3.15", "3.16", "3.17", "3.18", "3.19", "3.20"};
        /*给X轴设置数据*/
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues[(int) value];
            }
        });
        xAxis.setDrawLabels(true);

        //获取并设置Y轴
        YAxis leftYAxis = mScoreBarChart.getAxisLeft();//获取左侧Y轴
        YAxis rightYAxis = mScoreBarChart.getAxisRight();//获取右侧Y轴
        rightYAxis.setEnabled(false);//禁止显示右侧Y轴
        leftYAxis.setAxisLineWidth(0);
        leftYAxis.setDrawGridLines(true);
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setDrawLabels(true);

        /*3.添加数据*/
        ArrayList<BarEntry> entries1 = new ArrayList<>();//Entry就是折线图上的点
        entries1.add(new BarEntry(0, 66));
        entries1.add(new BarEntry(1, 75));
        entries1.add(new BarEntry(2, 88));
        entries1.add(new BarEntry(3, 92));
        entries1.add(new BarEntry(4, 70));
        entries1.add(new BarEntry(5, 90));
        entries1.add(new BarEntry(6, 80));

        BarDataSet barDataSet = new BarDataSet(entries1, "考试成绩");
        barDataSet.setColor(getResources().getColor(R.color.green));

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        mScoreBarChart.setData(barData);
        mScoreBarChart.invalidate();//刷新显示
    }
}
