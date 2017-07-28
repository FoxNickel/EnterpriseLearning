package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;

/**
 * Created by NickelFox on 2017/7/3.
 */

public class ThirdClassificationAdapter extends RecyclerView.Adapter<ThirdClassificationAdapter.ViewHolder> {
    private List<String> mThirdClassificationNameList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener = null;


    //define interface
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public ThirdClassificationAdapter(List<String> thirdClassificationNameList, Context context) {
        mThirdClassificationNameList = thirdClassificationNameList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_third_classification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (TextUtils.equals(mThirdClassificationNameList.get(position), "更多")) {
            holder.mTextView.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        }
        holder.mTextView.setText(mThirdClassificationNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return mThirdClassificationNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextView = (TextView) itemView.findViewById(R.id.tv_third_classification_name);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                //注意这里使用getTag方法获取position
                mOnItemClickListener.onItemClick(v, getPosition());
            }
        }

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
