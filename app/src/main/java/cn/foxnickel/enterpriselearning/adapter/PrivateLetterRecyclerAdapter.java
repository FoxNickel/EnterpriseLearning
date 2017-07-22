package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.bean.PrivateLetter;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by NickelFox on 17/7/4.
 */

public class PrivateLetterRecyclerAdapter extends RecyclerView.Adapter<PrivateLetterRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<PrivateLetter> mList;

    public PrivateLetterRecyclerAdapter(Context context, List<PrivateLetter> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_private_letter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mUserAvatar.setImageResource(R.drawable.login_bg2);
        holder.mUsername.setText(mList.get(position).getUserName());
        holder.mPrivateLetterContent.setText(mList.get(position).getPrivateLetterContent());
        holder.mReleaseTime.setText(mList.get(position).getReleaseTime());
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
        return mList.size();
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
