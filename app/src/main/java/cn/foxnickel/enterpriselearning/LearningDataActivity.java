package cn.foxnickel.enterpriselearning;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

public class LearningDataActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BarChart mLearningTimeBarChart, mScoreBarChart;
    private PieChart mTimePieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_data);
        initView();
        initTimeBarChart();
        initTimePieChart();
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
        final String[] xValues = {"7.14", "7.15", "7.16", "7.17", "7.18", "7.19", "7.20"};
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

    private void initTimePieChart() {
        mTimePieChart = (PieChart) findViewById(R.id.pie_chart_time);

        mTimePieChart.setUsePercentValues(true);
        mTimePieChart.getDescription().setEnabled(false);
        mTimePieChart.setExtraOffsets(5, 10, 5, 5);

        mTimePieChart.setDragDecelerationFrictionCoef(0.95f);

        //mTimePieChart.setCenterTextTypeface(mTfLight);
        mTimePieChart.setCenterText("学习时长分布");

        mTimePieChart.setDrawHoleEnabled(true);
        mTimePieChart.setHoleColor(Color.WHITE);

        mTimePieChart.setTransparentCircleColor(Color.WHITE);
        mTimePieChart.setTransparentCircleAlpha(110);

        mTimePieChart.setHoleRadius(58f);
        mTimePieChart.setTransparentCircleRadius(61f);

        mTimePieChart.setDrawCenterText(true);

        mTimePieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mTimePieChart.setRotationEnabled(true);
        mTimePieChart.setHighlightPerTapEnabled(true);

        String[] entryName = {"技术分享", "项目管理", "流程管理"};
        ArrayList<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(46, entryName[0]));
        entries.add(new PieEntry(24, entryName[1]));
        entries.add(new PieEntry(30, entryName[2]));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        mTimePieChart.setData(data);

        // undo all highlights
        mTimePieChart.highlightValues(null);

        mTimePieChart.invalidate();


        mTimePieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mTimePieChart.spin(2000, 0, 360);

        Legend l = mTimePieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mTimePieChart.setEntryLabelColor(Color.BLACK);
        mTimePieChart.setEntryLabelTextSize(12f);

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
        final String[] xValues = {"7.14", "7.15", "7.16", "7.17", "7.18", "7.19", "7.20"};
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
