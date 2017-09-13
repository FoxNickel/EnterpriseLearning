package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.bean.CourseRecommend;

/**
 * Created by NickelFox on 2017/7/2.
 */

public class SCRecommendAdapter extends RecyclerView.Adapter<SCRecommendAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<CourseRecommend> mList;

    public SCRecommendAdapter(Context context, ArrayList<CourseRecommend> list) {
        mContext = context;
        mList = list;
    }

    private int mCourseRecommendPic[] = {R.drawable.course_recommend_pic4, R.drawable.course_recommend_pic2,
            R.drawable.course_recommend_pic3, R.drawable.course_recommend_pic1};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_sc_recommend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mLinearLayout.setBackgroundResource(mCourseRecommendPic[position]);
        final CourseRecommend courseRecommend = mList.get(position);
        holder.mCourseName.setText(courseRecommend.getCourseName());
        holder.mChapterTitle.setText(courseRecommend.getChapterTitle());
        holder.mChapterDescription.setText(courseRecommend.getChapterDescription());
        holder.mLearningNumber.setText(courseRecommend.getLearningNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class).putExtra("course_name", courseRecommend.getCourseName()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View mLinearLayout;
        private TextView mCourseName, mChapterTitle, mChapterDescription, mLearningNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = itemView.findViewById(R.id.linear_layout);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mChapterTitle = (TextView) itemView.findViewById(R.id.tv_chapter_title);
            mChapterDescription = (TextView) itemView.findViewById(R.id.tv_chapter_description);
            mLearningNumber = (TextView) itemView.findViewById(R.id.tv_learning_numbers);
        }
    }
}
