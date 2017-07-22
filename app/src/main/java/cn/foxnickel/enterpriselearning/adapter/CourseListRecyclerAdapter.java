package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.bean.Course;

/**
 * Created by Night on 2017/7/15.
 */

public class CourseListRecyclerAdapter extends RecyclerView.Adapter<CourseListRecyclerAdapter.ViewHolder> {

    private List<Course> mList;
    private Context mContext;


    public CourseListRecyclerAdapter(Context context, List<Course> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_course_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvCourseName.setText(mList.get(position).getCourseName());
        holder.mRbCourseScore.setRating(mList.get(position).getCourseStars());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvCoursePic;
        private TextView mTvCourseName;
        private RatingBar mRbCourseScore;
        private TextView mTvCourseLearned;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvCoursePic = (ImageView) itemView.findViewById(R.id.iv_course_pic);
            mTvCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mTvCourseLearned = (TextView) itemView.findViewById(R.id.tv_course_learned);
            mRbCourseScore = (RatingBar) itemView.findViewById(R.id.rb_course_score);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
                }
            });
        }
    }
}
