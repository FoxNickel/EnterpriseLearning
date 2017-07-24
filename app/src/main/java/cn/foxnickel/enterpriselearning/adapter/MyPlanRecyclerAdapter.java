package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificPlanActivity;

/**
 * Created by Night on 2017/7/11.
 */

public class MyPlanRecyclerAdapter extends AnimRecyclerViewAdapter<MyPlanRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mPlanNameList;

    public MyPlanRecyclerAdapter(Context context, List<String> planNameList) {
        mContext = context;
        mPlanNameList = planNameList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_my_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mPlanName.setText(mPlanNameList.get(position));
        holder.mPlanState.setText("已学25%");
        switch (position) {
            case 0:
                holder.mIVPlan.setImageResource(R.drawable.new_employee);
                break;
            case 1:
                holder.mIVPlan.setImageResource(R.drawable.android2);
                break;
            case 2:
                holder.mIVPlan.setImageResource(R.drawable.android3);
                break;
            default:
                break;
        }
        showItemAnim(holder.rootview, position);
    }

    @Override
    public int getItemCount() {
        return mPlanNameList.size();
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
