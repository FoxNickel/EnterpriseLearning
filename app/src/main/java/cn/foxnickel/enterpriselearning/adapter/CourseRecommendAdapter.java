package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/2.
 */

public class CourseRecommendAdapter extends RecyclerView.Adapter<CourseRecommendAdapter.ViewHolder> {

    private Context mContext;

    public CourseRecommendAdapter(Context context) {
        mContext = context;
    }

    int mCourseRecommendPic[] = {R.drawable.course_recommend_pic4, R.drawable.course_recommend_pic2,
            R.drawable.course_recommend_pic3, R.drawable.course_recommend_pic1};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_course_recommend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mLinearLayout.setBackgroundResource(mCourseRecommendPic[position]);
        holder.mCourseName.setText("这是课程名称");
        holder.mChapterTitle.setText("这是章节名称");
        holder.mChapterDescription.setText("这是章节内容，这是章节内容，这是章节内容，这是章节内容。");
        holder.mLearningNumber.setText("3000人学习");
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
