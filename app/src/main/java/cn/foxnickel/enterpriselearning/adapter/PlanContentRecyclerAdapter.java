package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificPlanActivity;

/**
 * Created by Night on 2017/7/11.
 */

public class PlanContentRecyclerAdapter extends AnimRecyclerViewAdapter<PlanContentRecyclerAdapter.ViewHolder> {
    private Context mContext;


    public PlanContentRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_plan_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mPlanName.setText("新员工入职计划");
                holder.mPlanState.setText("未开始");
                break;
            case 1:
                holder.mIVPlan.setImageResource(R.drawable.service_communication);
                holder.mPlanName.setText("Android强化：\n\n服务与通信");
                holder.mPlanState.setText("未开始");
                break;
            case 2:
                holder.mIVPlan.setImageResource(R.drawable.data_storge);
                holder.mPlanName.setText("Android强化：\n\n网络与数据存储");
                holder.mPlanState.setText("未开始");
                break;
            case 3:
                holder.mIVPlan.setImageResource(R.drawable.high_anim);
                holder.mPlanName.setText("Android强化：\n\n高级动画开发");
                holder.mPlanState.setText("未开始");
                break;
            case 4:
                holder.mIVPlan.setImageResource(R.drawable.kotlin);
                holder.mPlanName.setText("Android强化：\n\nKotlin入门学习");
                holder.mPlanState.setText("未开始");
                break;
            default:
                break;
        }
        showItemAnim(holder.rootview, position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mPlanName;
        private ImageView mIVPlan;
        private TextView mPlanState;
        private View rootview;

        public ViewHolder(View itemView) {
            super(itemView);
            rootview = itemView;
            mPlanName = (TextView) itemView.findViewById(R.id.tv_plan_name);
            mIVPlan = (ImageView) itemView.findViewById(R.id.iv_plan);
            mPlanState = (TextView) itemView.findViewById(R.id.tv_plan_state);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, SpecificPlanActivity.class).putExtra("planname", mPlanName.getText().toString().trim()));
                }
            });
        }
    }
}
