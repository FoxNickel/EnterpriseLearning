package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by NickelFox on 17/7/4.
 */

public class PrivateLetterRecyclerAdapter extends RecyclerView.Adapter<PrivateLetterRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public PrivateLetterRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_private_letter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mUserAvatar.setImageResource(R.drawable.login_bg2);
        holder.mUsername.setText("管理员");
        holder.mPrivateLetterContent.setText("这是私信内容，这是私信内容，这是私信内容");
        holder.mReleaseTime.setText("07-01");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mUsername.setTextColor(mContext.getResources().getColor(R.color.gray));
                holder.mPrivateLetterContent.setTextColor(mContext.getResources().getColor(R.color.gray));
                holder.mReleaseTime.setTextColor(mContext.getResources().getColor(R.color.gray));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mUserAvatar;
        private TextView mUsername, mPrivateLetterContent, mReleaseTime;

        ViewHolder(View itemView) {
            super(itemView);
            mUserAvatar = (CircleImageView) itemView.findViewById(R.id.iv_user_avatar);
            mUsername = (TextView) itemView.findViewById(R.id.tv_username);
            mPrivateLetterContent = (TextView) itemView.findViewById(R.id.tv_private_letter_content);
            mReleaseTime = (TextView) itemView.findViewById(R.id.tv_release_date);
        }
    }
}
