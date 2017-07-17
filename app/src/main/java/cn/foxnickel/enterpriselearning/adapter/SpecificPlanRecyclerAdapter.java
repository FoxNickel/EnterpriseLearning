package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by Night on 2017/7/11.
 */

public class SpecificPlanRecyclerAdapter extends RecyclerView.Adapter<SpecificPlanRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mStageList;
    private List<List<String>> mStageNodeList;

    private OnItemClickListener mOnItemClickListener = null;


    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public SpecificPlanRecyclerAdapter(Context context, List<String> planStage, List<List<String>> planStageNode) {
        mContext = context;
        mStageList = planStage;
        mStageNodeList = planStageNode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_plan_specific, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        holder.mStageName.setText(mStageList.get(position));
        PlanStageRecyclerAdapter planStageRecyclerAdapter = new PlanStageRecyclerAdapter(mContext, mStageNodeList.get(position));
        holder.mRecyclerView.setAdapter(planStageRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return mStageList.size();
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
