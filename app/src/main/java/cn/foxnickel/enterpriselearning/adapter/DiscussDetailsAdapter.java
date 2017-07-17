/**
 * Created by Night on 2017/7/15.
 * Desc:
 */
package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.CommentActivity;
import cn.foxnickel.enterpriselearning.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Night
 * @since 2017-07-15
 */
public class DiscussDetailsAdapter extends RecyclerView.Adapter<DiscussDetailsAdapter.ViewHolder> {
    private Context context;


    public DiscussDetailsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_discuss_all_answer, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mTvAnswererName.setText("123456小王");
                holder.mTvReceived.setTextColor(Color.GREEN);
                break;
            case 1:
                holder.mTvAnswererName.setText("123457小李");
                holder.mTvAnswer.setText("楼上正解");
                holder.mTvReceived.setVisibility(View.GONE);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        private CircleImageView mIvQuestioner;
        private TextView mTvAnswererName;
        private TextView mTvAnswer;
        private ImageView mIvGood;
        private TextView mTvGoodCount;
        private ImageView mIvComment;
        private TextView mTvCommentCount;
        private TextView mTvReceived;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            mIvComment = (ImageView) rootView.findViewById(R.id.iv_comment);
            mIvQuestioner = (CircleImageView) rootView.findViewById(R.id.iv_answer);
            mTvAnswererName = (TextView) rootView.findViewById(R.id.tv_answer_name);
            mTvAnswer = (TextView) rootView.findViewById(R.id.tv_answer);
            mIvGood = (ImageView) rootView.findViewById(R.id.iv_good);
            mTvGoodCount = (TextView) rootView.findViewById(R.id.tv_good_count);
            mTvCommentCount = (TextView) rootView.findViewById(R.id.tv_comment_count);
            mTvReceived = (TextView) rootView.findViewById(R.id.tv_received);
            mIvGood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getTag() == null) {
                        v.setTag(true);
                        v.setBackgroundResource(R.drawable.ic_thumbs_up_red);
                        mTvGoodCount.setText(Integer.parseInt(mTvGoodCount.getText().toString().trim()) + 1 + "");
                    }
                }
            });
            mIvComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CommentActivity.class));
                }
            });
        }
    }
}
