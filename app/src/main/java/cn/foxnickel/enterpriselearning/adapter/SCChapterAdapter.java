package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.PlayPPTActivity;
import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.bean.Chapter;
import cn.foxnickel.enterpriselearning.utils.Resources;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class SCChapterAdapter extends RecyclerView.Adapter<SCChapterAdapter.ViewHolder> {

    private List<Chapter> mList;
    private Context mContext;
    private List<Boolean> isClicks;//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色


    public SCChapterAdapter(Context context, List<Chapter> list) {
        mContext = context;
        isClicks = new ArrayList<>();
        mList = list;
        for (int i = 0; i < mList.size(); i++) {
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
        final Chapter chapter = mList.get(position);
        if (chapter.isChapter()) {
            holder.mIVStop.setVisibility(View.GONE);
            holder.mChapterName.setTextSize(14);
            holder.mChapterTime.setVisibility(View.GONE);
            holder.itemView.setClickable(false);
        } else {
            holder.mIVStop.setVisibility(View.VISIBLE);
            holder.mChapterName.setTextSize(12);
            holder.mChapterTime.setVisibility(View.VISIBLE);
        }
        holder.mChapterName.setText(chapter.getChapterName());
        if (isClicks.get(position)) {
            Log.e("TAG", "come in");
            if (chapter.getResources() == Resources.PPT) {
                holder.mIVStop.setBackgroundResource(R.drawable.ic_ppt_red);
            } else {
                holder.mIVStop.setBackgroundResource(R.drawable.ic_stop_red_24dp);
                SpecificCouseActivity.mVpPlayer.getTitleTextView().setText(holder.mChapterName.getText().toString());
            }
            holder.mChapterName.setTextColor(Color.argb(255, 253, 47, 81));
            holder.mChapterTime.setTextColor(Color.argb(255, 253, 47, 81));
        } else {
            if (chapter.getResources() == Resources.PPT) {
                holder.mIVStop.setBackgroundResource(R.drawable.ic_ppt_gray);
            } else {
                holder.mIVStop.setBackgroundResource(R.drawable.ic_stop_gray_24dp);
            }
            holder.mChapterName.setTextColor(Color.BLACK);
            holder.mChapterTime.setTextColor(Color.BLACK);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chapter.isChapter()) {
                    for (int i = 0; i < isClicks.size(); i++) {
                        isClicks.set(i, false);
                    }
                    isClicks.set(position, true);
                    Log.e("TAG", position + "");
                    notifyDataSetChanged();
                    if (chapter.getResources() == Resources.PPT) {
                        SpecificCouseActivity.mVpPlayer.onVideoPause();
                        mContext.startActivity(new Intent(mContext, PlayPPTActivity.class));
                    } else if (chapter.getResources() == Resources.VIDEO) {
                        if (!TextUtils.isEmpty(chapter.getUrl())) {
                            SpecificCouseActivity.mVpPlayer.setUp(chapter.getUrl(), false, chapter.getChapterName());
                            SpecificCouseActivity.mVpPlayer.startPlayLogic();
                        }
                    }
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return mList.size();
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
