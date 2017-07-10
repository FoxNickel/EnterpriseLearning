package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
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

public class SCQAAdapter extends RecyclerView.Adapter<SCQAAdapter.ViewHolder> {

    private Context mContext;


    public SCQAAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_question_answer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.mExamName.setText("UI怎么切图");
            holder.mWriteAnswer.setVisibility(View.GONE);
            holder.mLastAnswer.setText("[最新 沐曦尘x 的回答] ps里面有切片工具");
        } else if (position % 3 == 0) {
            holder.mExamName.setText("有哪些浏览器支持css3？");
            holder.mWriteAnswer.setVisibility(View.GONE);
            holder.mLastAnswer.setText("[已采纳 梦飞翔2 的回答] ie9+；chrome；flex以及主流浏览器");

        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mExamName;
        private ImageView mWriteAnswer;
        private TextView mLastAnswer;

        public ViewHolder(View itemView) {
            super(itemView);
            mExamName = (TextView) itemView.findViewById(R.id.tv_question_name);
            mWriteAnswer = (ImageView) itemView.findViewById(R.id.iv_write_answer);
            mLastAnswer = (TextView) itemView.findViewById(R.id.tv_last_answer);
        }
    }
}
