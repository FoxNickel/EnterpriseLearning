package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;

import cn.foxnickel.enterpriselearning.DiscussDetailsActivity;
import cn.foxnickel.enterpriselearning.R;

/**
 * Created by Night on 2017/7/11.
 */

public class MyDiscussRecyclerAdapter extends AnimRecyclerViewAdapter<MyDiscussRecyclerAdapter.ViewHolder> {
    private Context mContext;


    public MyDiscussRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_my_discuss, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position % 2 != 0) {
            holder.mTvDiscussName.setText("UI怎么切图");
            holder.mTvDiscussContent.setText("[最新 沐曦尘x 的回答] ps里面有切片工具");
            holder.mTvDiscussContent.setTextToHighlight("[最新 沐曦尘x 的回答]");
            holder.mTvDiscussContent.setTextHighlightColor(R.color.colorPrimary);
            holder.mTvDiscussContent.setCaseInsensitive(false);
            holder.mTvDiscussContent.setHighlightMode(HighlightMode.TEXT);
            holder.mTvDiscussContent.highlight();
        } else {
            holder.mTvDiscussName.setText("有哪些浏览器支持css3？");
            holder.mTvDiscussContent.setText("[已采纳 梦飞翔2 的回答] ie9+；chrome；flex\n以及主流浏览器");
            holder.mTvDiscussContent.setTextToHighlight("[已采纳 梦飞翔2 的回答]");
            holder.mTvDiscussContent.setTextHighlightColor(R.color.green);
            holder.mTvDiscussContent.setCaseInsensitive(false);
            holder.mTvDiscussContent.setHighlightMode(HighlightMode.TEXT);
            holder.mTvDiscussContent.highlight();
        }

        showItemAnim(holder.rootview, position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDiscussName;
        private EmphasisTextView mTvDiscussContent;
        private TextView mTvDiscussTime;
        private TextView mTvDiscussFrom;
        private View rootview;

        public ViewHolder(View itemView) {
            super(itemView);
            rootview = itemView;
            mTvDiscussName = (TextView) itemView.findViewById(R.id.tv_discuss_name);
            mTvDiscussContent = (EmphasisTextView) itemView.findViewById(R.id.tv_discuss_content);
            mTvDiscussTime = (TextView) itemView.findViewById(R.id.tv_discuss_time);
            mTvDiscussFrom = (TextView) itemView.findViewById(R.id.tv_discuss_from);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, DiscussDetailsActivity.class));
                }
            });
        }
    }
}
