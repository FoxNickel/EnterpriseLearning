package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class SCChapterAdapter extends RecyclerView.Adapter<SCChapterAdapter.ViewHolder> {

    private Context mContext;


    public SCChapterAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_sc_chapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (position == 0) {
            holder.mIVStop.setVisibility(View.GONE);
            holder.mChapterName.setText("第1章webUI课程简介");
            holder.mChapterTime.setVisibility(View.GONE);
        } else if (position == 1) {
            holder.mChapterName.setText("1-1课程介绍");
            holder.mChapterName.setTextSize(12);
        } else if (position == 2) {
            holder.mIVStop.setVisibility(View.GONE);
            holder.mChapterName.setText("第2章webUI课程简介");
            holder.mChapterTime.setVisibility(View.GONE);
        } else {
            holder.mChapterName.setText("2-" + position + "课程介绍");
            holder.mChapterName.setTextSize(12);
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIVStop;
        private TextView mChapterName;
        private TextView mChapterTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mIVStop = (ImageView) itemView.findViewById(R.id.iv_stop);
            mChapterName = (TextView) itemView.findViewById(R.id.tv_chapter_name);
            mChapterTime = (TextView) itemView.findViewById(R.id.tv_chapter_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIVStop.setBackgroundResource(R.drawable.ic_stop_red_24dp);
                    mChapterName.setTextColor(Color.argb(255, 253, 47, 81));
                    mChapterTime.setTextColor(Color.argb(255, 253, 47, 81));
                }
            });
        }
    }
}
