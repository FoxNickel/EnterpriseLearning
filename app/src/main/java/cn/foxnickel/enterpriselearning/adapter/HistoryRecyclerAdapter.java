package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/9.
 */

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public HistoryRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_history, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        holder.mTime.setText("今天");
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        HistoryItemRecyclerAdapter historyItemRecyclerAdapter = new HistoryItemRecyclerAdapter(mContext);
        holder.mRecyclerView.setAdapter(historyItemRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTime;
        private RecyclerView mRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTime = (TextView) itemView.findViewById(R.id.tv_time);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_history_item);
        }
    }
}
