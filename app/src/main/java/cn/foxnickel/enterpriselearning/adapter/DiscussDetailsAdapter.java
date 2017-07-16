/**
 * Created by Night on 2017/7/15.
 * Desc:
 */
package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Night
 * @since 2017-07-15
 */
public class DiscussDetailsAdapter extends RecyclerView.Adapter<DiscussDetailsAdapter.ViewHolder> {
    private final Context context;


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
        holder.mTvAnswer.setText("night");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        private CircleImageView mIvQuestioner;
        private TextView mTvAnswererName;
        private TextView mTvAnswer;
        private ImageView mIvGood;
        private TextView mTvGoodCount;
        private ImageView mIvComment;
        private TextView mTvCommentCount;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            mIvQuestioner = (CircleImageView) rootView.findViewById(R.id.iv_questioner);
            mTvAnswererName = (TextView) rootView.findViewById(R.id.tv_answer_name);
            mTvAnswer = (TextView) rootView.findViewById(R.id.tv_answer);
            mIvGood = (ImageView) rootView.findViewById(R.id.iv_good);
            mTvGoodCount = (TextView) rootView.findViewById(R.id.tv_good_count);
            mTvCommentCount = (TextView) rootView.findViewById(R.id.tv_comment_count);
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
        }
    }
}
