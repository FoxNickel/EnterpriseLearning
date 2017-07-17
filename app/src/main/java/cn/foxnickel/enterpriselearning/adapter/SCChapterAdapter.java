package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class SCChapterAdapter extends RecyclerView.Adapter<SCChapterAdapter.ViewHolder> {

    private Context mContext;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色


    public SCChapterAdapter(Context context) {
        mContext = context;
        isClicks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            isClicks.add(false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_sc_chapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        switch (position) {
            case 0:
                holder.mIVStop.setVisibility(View.GONE);
                holder.mChapterName.setText("第1章 webUI课程简介");
                holder.mChapterName.setTextSize(14);
                holder.mChapterTime.setVisibility(View.GONE);
                break;
            case 1:
                holder.mChapterName.setText("1-1课程介绍");
                holder.mChapterName.setTextSize(12);
                break;
            case 2:
                holder.mIVStop.setVisibility(View.GONE);
                holder.mChapterName.setText("第2章 从设计角度初识web页面");
                holder.mChapterName.setTextSize(14);
                holder.mChapterTime.setVisibility(View.GONE);
                break;
            case 3:
                holder.mChapterName.setText("2-1 webUI是什么");
                holder.mChapterName.setTextSize(12);
                break;
            case 4:
                holder.mChapterName.setText("2-2 关于分辨率");
                holder.mChapterName.setTextSize(12);
                break;
            case 5:
                holder.mChapterName.setText("2-3 web的基本分类");
                holder.mChapterName.setTextSize(12);
                break;
            case 6:
                holder.mChapterName.setText("2-4 网页是如何实现的");
                holder.mChapterName.setTextSize(12);
                break;
            default:
                break;
        }

        if (isClicks.get(position)) {
            holder.mIVStop.setBackgroundResource(R.drawable.ic_stop_red_24dp);
            holder.mChapterName.setTextColor(Color.argb(255, 253, 47, 81));
            holder.mChapterTime.setTextColor(Color.argb(255, 253, 47, 81));
        } else {
            holder.mIVStop.setBackgroundResource(R.drawable.ic_stop_gray_24dp);
            holder.mChapterName.setTextColor(Color.BLACK);
            holder.mChapterTime.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < isClicks.size(); i++) {
                    isClicks.set(i, false);
                }
                isClicks.set(position, true);
                notifyDataSetChanged();
                SpecificCouseActivity.mVpPlayer.startPlayLogic();

            }
        });
    }


    @Override
    public int getItemCount() {
        return 7;
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

        }
    }
}
