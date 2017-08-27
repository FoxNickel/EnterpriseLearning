package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.bean.Course;

/**
 * Created by NickelFox on 2017/7/28.
 */

public class MyCollectRecyclerAdapter extends RecyclerView.Adapter<MyCollectRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<Course> mCourseList;


    public MyCollectRecyclerAdapter(Context context, List<Course> courseList) {
        mContext = context;
        mCourseList = courseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_my_collect, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = mCourseList.get(position);
        holder.mCourseName.setText(course.getCourseName());
        int learningRate = course.getLearningRate();
        if (learningRate != 0) {
            holder.mTvLearnRate.setText("已学习" + learningRate + "%");
            holder.mTvLastLearnTime.setText("上次学习时间：" + course.getLastLearningTime());
        } else {
            holder.mTvLearnRate.setText("开始学习");
            holder.mTvLastLearnTime.setText("");

        }
        holder.mCoursePic.setImageResource(Integer.valueOf(course.getCoursePic()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCourseName;
        private ImageView mCoursePic;
        private TextView mTvLearnRate;
        private TextView mTvLastLearnTime;
        private View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mTvLearnRate = (TextView) itemView.findViewById(R.id.tv_learn_rate);
            mTvLastLearnTime = (TextView) itemView.findViewById(R.id.tv_last_learn_time);
            mCoursePic = (ImageView) itemView.findViewById(R.id.iv_course_pic);
        }
    }
}
