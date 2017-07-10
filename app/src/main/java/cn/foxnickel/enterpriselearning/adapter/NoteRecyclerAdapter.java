package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/8.
 */

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public NoteRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_note, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mTime.setText("2017-07-07");
        holder.mContent.setText("这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记，这是笔记");
        holder.mExpand.setOnClickListener(new View.OnClickListener() {
            boolean expanded = false;

            @Override
            public void onClick(View v) {
                if (expanded) {
                    holder.mContent.setMaxLines(2);
                    holder.mExpand.setText("展开");
                    expanded = false;
                } else {
                    holder.mContent.setMaxLines(9999);
                    holder.mExpand.setText("收起");
                    expanded = true;
                }
            }
        });

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "删除了一条笔记", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTime, mContent, mExpand;
        private ImageView mDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mTime = (TextView) itemView.findViewById(R.id.tv_note_time);
            mContent = (TextView) itemView.findViewById(R.id.tv_note_content);
            mExpand = (TextView) itemView.findViewById(R.id.tv_expand);
            mDelete = (ImageView) itemView.findViewById(R.id.iv_delete);
        }
    }
}
