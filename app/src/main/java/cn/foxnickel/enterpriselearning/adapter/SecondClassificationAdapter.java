package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

/**
 * Created by NickelFox on 2017/7/3.
 */

public class SecondClassificationAdapter extends RecyclerView.Adapter<SecondClassificationAdapter.ViewHolder> {

    private List<String> mSecondClassificationNameList, mThirdClassificationNameList;
    private Context mContext;

    public SecondClassificationAdapter(List<String> secondClassificationNameList, List<String> thirdClassificationNameList, Context context) {
        mSecondClassificationNameList = secondClassificationNameList;
        mThirdClassificationNameList = thirdClassificationNameList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_second_classification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mSecondClassificationName.setText(mSecondClassificationNameList.get(position));
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
        holder.mThirdClassificationRecycler.setLayoutManager(manager);
        ThirdClassificationAdapter thirdClassificationAdapter = new ThirdClassificationAdapter(mThirdClassificationNameList, mContext);
        thirdClassificationAdapter.setOnItemClickListener(new ThirdClassificationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
            }
        });
        holder.mThirdClassificationRecycler.setAdapter(thirdClassificationAdapter);
    }

    @Override
    public int getItemCount() {
        return mSecondClassificationNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mSecondClassificationName;
        private RecyclerView mThirdClassificationRecycler;

        public ViewHolder(View itemView) {
            super(itemView);
            mSecondClassificationName = (TextView) itemView.findViewById(R.id.tv_second_classification_name);
            mThirdClassificationRecycler = (RecyclerView) itemView.findViewById(R.id.recycler_view_third_classification);
        }
    }
}
