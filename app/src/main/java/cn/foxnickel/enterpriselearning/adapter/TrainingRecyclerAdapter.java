package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.TrainingDetailActivity;

/**
 * Created by NickelFox on 2017/7/8.
 */

public class TrainingRecyclerAdapter extends RecyclerView.Adapter<TrainingRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public TrainingRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_training, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTrainingName.setText("这是培训名称");
        holder.mIntro.setText("        培训介绍：这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍");
        holder.mNum.setText("报名人数:36人");
        holder.mPlace.setText("培训地点:二楼会议室");
        holder.mStartTime.setText("开始时间:2017年7月7日 12:00");
        holder.mDuration.setText("培训时长:2小时");
        holder.mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTrainingDetailActivity = new Intent(mContext, TrainingDetailActivity.class);
                startTrainingDetailActivity.putExtra("training_name", "这是培训名称");
                startTrainingDetailActivity.putExtra("training_intro", "        这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍，这是培训介绍");
                startTrainingDetailActivity.putExtra("training_num", "报名人数:36人");
                startTrainingDetailActivity.putExtra("training_place", "培训地点:二楼会议室");
                startTrainingDetailActivity.putExtra("training_start_time", "开始时间:2017年7月7日 12:00");
                startTrainingDetailActivity.putExtra("training_duration", "培训时长:2小时");

                mContext.startActivity(startTrainingDetailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
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
