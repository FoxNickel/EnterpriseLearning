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
 * Created by Night on 2017/7/11.
 */

public class SpecificPlanRecyclerAdapter extends RecyclerView.Adapter<SpecificPlanRecyclerAdapter.ViewHolder> {
    private Context mContext;


    public SpecificPlanRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_plan_specific, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mStageName.setText("第一阶段产品介绍");
                break;
            case 1:
                holder.mStageName.setText("第二阶段产品介绍");
                break;
            case 2:
                holder.mStageName.setText("第三阶段产品介绍");
                break;
            default:
                break;
        }
        PlanStageRecyclerAdapter planStageRecyclerAdapter = new PlanStageRecyclerAdapter(mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        holder.mRecyclerView.setAdapter(planStageRecyclerAdapter);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mStageName;
        private RecyclerView mRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            mStageName = (TextView) itemView.findViewById(R.id.tv_plan_stage);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rv_plan_stage);
        }
    }
}
