package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.bean.Note;

/**
 * Created by NickelFox on 2017/7/8.
 */

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private List<Note> mList;
    private Context mContext;

    public NoteRecyclerAdapter(Context context, List<Note> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_note, viewGroup, false);
        return new ViewHolder(view);
    }

    boolean expanded = false;

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mTime.setText(mList.get(position).getTime());
        holder.mContent.setText(mList.get(position).getContent());
        holder.mSource.setText(mList.get(position).getSourse());
        holder.mExpand.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (expanded) {
                    holder.mContent.setMaxLines(2);
                    holder.mExpand.setText("展开");
                    expanded = false;
                } else {
                    holder.mContent.setMaxLines(9999);
                    holder.mExpand.setText("收起");
                    holder.mSource.setVisibility(View.VISIBLE);
                    expanded = true;
                }
            }
        });

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(mContext, "删除了一条笔记", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTime, mContent, mExpand, mSource;
        private ImageView mDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mTime = (TextView) itemView.findViewById(R.id.tv_note_time);
            mContent = (TextView) itemView.findViewById(R.id.tv_note_content);
            mExpand = (TextView) itemView.findViewById(R.id.tv_expand);
            mDelete = (ImageView) itemView.findViewById(R.id.iv_delete);
            mSource = (TextView) itemView.findViewById(R.id.tv_source);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (expanded) {
                        mContent.setMaxLines(2);
                        mExpand.setText("展开");
                        expanded = false;
                    } else {
                        mContent.setMaxLines(9999);
                        mExpand.setText("收起");
                        mSource.setVisibility(View.VISIBLE);
                        expanded = true;
                    }
                }
            });
        }
    }
}
