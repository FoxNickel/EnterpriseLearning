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

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

/**
 * Created by Night on 2017/7/15.
 */

public class CourseListRecyclerAdapter extends RecyclerView.Adapter<CourseListRecyclerAdapter.ViewHolder> {

    private Context mContext;


    public CourseListRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_course_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 8;
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
