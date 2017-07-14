package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.PlayVideoActivity;
import cn.foxnickel.enterpriselearning.R;

/**
 * Created by Night on 2017/7/11.
 */

public class PlanStageRecyclerAdapter extends RecyclerView.Adapter<PlanStageRecyclerAdapter.ViewHolder> {
    private Context mContext;


    public PlanStageRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_plan_stage_specific, null, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCourseName.setText("课时1:产品详解01");
        holder.mFinished.setText("已完成100%");
        holder.mCourseProgress.setProgress(100);
        holder.mCourseProgress.setProgressTintList(ColorStateList.valueOf(Color.RED));
        if (position == 1) {
            holder.mCourseName.setText("课时2:产品详解02");
            holder.mFinished.setText("已完成70%");
            holder.mCourseProgress.setProgress(70);
        } else if (position == 2) {
            holder.mCourseName.setText("课时3:产品详解03");
            holder.mFinished.setVisibility(View.GONE);
            holder.mCourseProgress.setProgress(0);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCourseName, mFinished;
        private ProgressBar mCourseProgress;

        public ViewHolder(View itemView) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mFinished = (TextView) itemView.findViewById(R.id.tv_finished);
            mCourseProgress = (ProgressBar) itemView.findViewById(R.id.pb_finished);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, PlayVideoActivity.class).putExtra("title", mCourseName.getText().toString().trim()));
                }
            });
        }
    }
}
