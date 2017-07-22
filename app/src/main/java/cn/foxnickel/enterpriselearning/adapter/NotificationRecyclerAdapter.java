package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.bean.Notification;

/**
 * Created by NickelFox on 17/7/4.
 */

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.ViewHolder> {

    private List<Notification> mList;
    private Context mContext;

    public NotificationRecyclerAdapter(Context context, List<Notification> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public NotificationRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_notification, parent, false);
        return new NotificationRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mUsername.setText("管理员");
        holder.mNotificationContent.setText(mList.get(position).getPrivateLetterContent());
        holder.mReleaseTime.setText(mList.get(position).getReleaseTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mUsername.setTextColor(mContext.getResources().getColor(R.color.gray));
                holder.mNotificationContent.setTextColor(mContext.getResources().getColor(R.color.gray));
                holder.mReleaseTime.setTextColor(mContext.getResources().getColor(R.color.gray));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mUsername, mNotificationContent, mReleaseTime;

        ViewHolder(View itemView) {
            super(itemView);
            mUsername = (TextView) itemView.findViewById(R.id.tv_username);
            mNotificationContent = (TextView) itemView.findViewById(R.id.tv_notification_content);
            mReleaseTime = (TextView) itemView.findViewById(R.id.tv_release_time);
        }
    }
}
