package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

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
        switch (position) {
            case 0:
                holder.mCourseName.setText("设计基础");
                holder.mChapterTitle.setText("UI设计小锦囊");
                holder.mChapterDescription.setText("成为UI设计师的正确打开方法");
                holder.mLearningNumber.setText("3000人学习");
                break;
            case 1:
                holder.mCourseName.setText("Android");
                holder.mChapterTitle.setText("Android常用异常集及解决方案");
                holder.mChapterDescription.setText("介绍Android常用异常集及解决方案");
                holder.mLearningNumber.setText("3000人学习");
                break;
            case 2:
                holder.mCourseName.setText("Android");
                holder.mChapterTitle.setText("Android语音词典");
                holder.mChapterDescription.setText("讲解第三方讯飞语音如何使用，" +
                        "如何实现数据解析");
                holder.mLearningNumber.setText("3000人学习");
                break;
            case 3:
                holder.mCourseName.setText("Android");
                holder.mChapterTitle.setText("APP性能优化之内存优化");
                holder.mChapterDescription.setText("介绍内存优化的理论，优化的问题，方法等知识");
                holder.mLearningNumber.setText("3000人学习");
                break;
            default:
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
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
