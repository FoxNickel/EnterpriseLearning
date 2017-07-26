package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.MyTrainingDetailActivity;
import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.bean.Training;

/**
 * Created by NickelFox on 2017/7/8.
 */

public class MyTrainingRecyclerAdapter extends RecyclerView.Adapter<MyTrainingRecyclerAdapter.ViewHolder> {

    private List<Training> mList;
    private Context mContext;

    public MyTrainingRecyclerAdapter(Context context, List<Training> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_training, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTrainingName.setText(mList.get(position).getTrainingName());
        holder.mIntro.setText(mList.get(position).getIntro());
        holder.mNum.setText("报名人数:" + mList.get(position).getNum() + "人");
        holder.mPlace.setText("培训地点:" + mList.get(position).getPlace());
        holder.mStartTime.setText("开始时间:" + mList.get(position).getStartTime());
        holder.mDuration.setText("培训时长:" + mList.get(position).getDuration());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTrainingDetailActivity = new Intent(mContext, MyTrainingDetailActivity.class);
                startTrainingDetailActivity.putExtra("training_name", mList.get(position).getTrainingName());
                startTrainingDetailActivity.putExtra("training_intro", mList.get(position).getTrainingName());
                startTrainingDetailActivity.putExtra("training_num", "报名人数:" + mList.get(position).getNum() + "人");
                startTrainingDetailActivity.putExtra("training_place", "培训地点:" + mList.get(position).getPlace());
                startTrainingDetailActivity.putExtra("training_start_time", "开始时间:" + mList.get(position).getStartTime());
                startTrainingDetailActivity.putExtra("training_duration", "培训时长:" + mList.get(position).getDuration());
                mContext.startActivity(startTrainingDetailActivity);
            }
        });
        holder.mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTrainingDetailActivity = new Intent(mContext, MyTrainingDetailActivity.class);
                startTrainingDetailActivity.putExtra("training_name", mList.get(position).getTrainingName());
                startTrainingDetailActivity.putExtra("training_intro", mList.get(position).getTrainingName());
                startTrainingDetailActivity.putExtra("training_num", "报名人数:" + mList.get(position).getNum() + "人");
                startTrainingDetailActivity.putExtra("training_place", "培训地点:" + mList.get(position).getPlace());
                startTrainingDetailActivity.putExtra("training_start_time", "开始时间:" + mList.get(position).getStartTime());
                startTrainingDetailActivity.putExtra("training_duration", "培训时长:" + mList.get(position).getDuration());
                mContext.startActivity(startTrainingDetailActivity);
            }
        });

        holder.mSignUp.setText("已报名");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private Button mSignUp;
        private TextView mTrainingName, mIntro, mNum, mPlace, mStartTime, mDuration;

        public ViewHolder(View view) {
            super(view);
            mTrainingName = (TextView) view.findViewById(R.id.tv_training_name);
            mSignUp = (Button) view.findViewById(R.id.bt_sign_up);
            mIntro = (TextView) view.findViewById(R.id.tv_training_intro);
            mNum = (TextView) view.findViewById(R.id.tv_num);
            mPlace = (TextView) view.findViewById(R.id.tv_place);
            mStartTime = (TextView) view.findViewById(R.id.tv_start_time);
            mDuration = (TextView) view.findViewById(R.id.tv_duration);


        }
    }
}
