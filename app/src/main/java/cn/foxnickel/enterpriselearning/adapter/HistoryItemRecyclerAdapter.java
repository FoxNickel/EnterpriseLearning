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
 * Created by NickelFox on 2017/7/9.
 */

public class HistoryItemRecyclerAdapter extends RecyclerView.Adapter<HistoryItemRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public HistoryItemRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_history_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.mCourseName.setText("Java-从入门到放弃");
        holder.mChapterName.setText("1-1 如何放弃Java");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCourseName, mChapterName;

        public ViewHolder(View itemView) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mChapterName = (TextView) itemView.findViewById(R.id.tv_chapter_name);
        }
    }
}
