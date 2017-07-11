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
 * Created by Night on 2017/7/11.
 */

public class PlanContentRecyclerAdapter extends RecyclerView.Adapter<PlanContentRecyclerAdapter.ViewHolder> {
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
        holder.mPlanName.setText("新员工入职计划");
        if (position % 2 == 0) {
            holder.mPlanState.setText("未开始");
        } else {
            holder.mPlanState.setText("已开始");
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mPlanName;
        private ImageView mIVPlan;
        private TextView mPlanState;

        public ViewHolder(View itemView) {
            super(itemView);
            mPlanName = (TextView) itemView.findViewById(R.id.tv_plan_name);
            mIVPlan = (ImageView) itemView.findViewById(R.id.iv_plan);
            mPlanState = (TextView) itemView.findViewById(R.id.tv_plan_state);
        }
    }
}
