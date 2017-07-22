package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.ExamActivity;
import cn.foxnickel.enterpriselearning.PlayVideoActivity;
import cn.foxnickel.enterpriselearning.R;

/**
 * Created by Night on 2017/7/11.
 */

public class PlanStageRecyclerAdapter extends RecyclerView.Adapter<PlanStageRecyclerAdapter.ViewHolder> {
    private boolean f;
    private List<String> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener = null;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色


    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public PlanStageRecyclerAdapter(Context context, List<String> list, boolean f1) {
        mContext = context;
        mList = list;
        isClicks = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            isClicks.add(false);
        }
        f = f1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_plan_stage_specific, null, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mCourseName.setText(mList.get(position));
        holder.mFinished.setVisibility(View.GONE);
        if (position == mList.size() - 1 && f) {
            holder.mCourseProgress.setVisibility(View.GONE);
            holder.mIvStop.setVisibility(View.GONE);
        }
        holder.mCourseProgress.setProgress(0);
        if (isClicks.get(position)) {
            holder.mCourseName.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.mFinished.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            holder.mIvStop.setImageResource(R.drawable.ic_play_red);
        } else {
            holder.mCourseName.setTextColor(Color.BLACK);
            holder.mFinished.setTextColor(Color.BLACK);
            holder.mIvStop.setImageResource(R.drawable.ic_play_gray);

        }
        //holder.mCourseProgress.setProgressTintList(ColorStateList.valueOf(Color.RED));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < isClicks.size(); i++) {
                    isClicks.set(i, false);
                }
                isClicks.set(position, true);
                notifyDataSetChanged();
                if (position != mList.size() - 1) {
                    mContext.startActivity(new Intent(mContext, PlayVideoActivity.class).putExtra("title", holder.mCourseName.getText().toString().trim()));
                } else {
                    mContext.startActivity(new Intent(mContext, ExamActivity.class));
                }
                 /*   mFinished.setVisibility(View.VISIBLE);
                    mFinished.setText("已完成10%");
                    mFinished.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                    mCourseProgress.setProgress(10);
                    mCourseProgress.setProgressTintList(ColorStateList.valueOf(Color.RED));
*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCourseName, mFinished;
        private ProgressBar mCourseProgress;
        private ImageView mIvStop;

        public ViewHolder(View itemView) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mFinished = (TextView) itemView.findViewById(R.id.tv_finished);
            mIvStop = (ImageView) itemView.findViewById(R.id.imageView4);
            mCourseProgress = (ProgressBar) itemView.findViewById(R.id.pb_finished);

        }
    }
}
