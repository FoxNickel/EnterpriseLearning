package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class MyExamRecyclerAdapter extends RecyclerView.Adapter<MyExamRecyclerAdapter.ViewHolder> {

    private Context mContext;


    public MyExamRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_my_exam, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mExamName.setText("新员工入职考试");
        if (position % 2 == 0) {
            holder.mExamScore.setText("80分");
            holder.mExamTime.setText("2017-5-11");
        } else if (position % 3 == 0) {
            holder.mExamScore.setText("60分");
            holder.mExamScore.setBackgroundResource(R.drawable.shape_exam_score_yellow);
            holder.mExamTime.setText("2017-5-11");
        } else {
            holder.mExamScore.setText("50分");
            holder.mExamScore.setBackgroundResource(R.drawable.shape_exam_score_red);
            holder.mExamTime.setText("2017-5-11");
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mExamName;
        private TextView mExamScore;
        private TextView mExamTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mExamName = (TextView) itemView.findViewById(R.id.tv_exam_name);
            mExamScore = (TextView) itemView.findViewById(R.id.tv_exam_score);
            mExamTime = (TextView) itemView.findViewById(R.id.tv_exam_time);
        }
    }
}
