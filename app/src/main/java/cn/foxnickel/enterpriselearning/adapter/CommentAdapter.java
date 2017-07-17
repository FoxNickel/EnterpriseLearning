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
import android.widget.TextView;

import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;

import cn.foxnickel.enterpriselearning.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Night
 * @since 2017-07-16
 */
public class CommentAdapter extends AnimRecyclerViewAdapter<CommentAdapter.ViewHolder> {
    private final Context context;


    public CommentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_comment, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 1) {
            holder.mTvAnswerName.setText("123457小李");
            holder.mTvAnswer.setText("回复 123456小王 自行百度吧");
            holder.mTvAnswer.setTextToHighlight("123456小王");
            holder.mTvAnswer.setTextHighlightColor(R.color.gray);
            holder.mTvAnswer.setCaseInsensitive(false);
            holder.mTvAnswer.setHighlightMode(HighlightMode.TEXT);
            holder.mTvAnswer.highlight();
            holder.mTvCommentTime.setText("2017-07-07");
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        private CircleImageView mIvAnswer;
        private TextView mTvAnswerName;
        private EmphasisTextView mTvAnswer;
        private TextView mTvCommentTime;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            mIvAnswer = (CircleImageView) rootView.findViewById(R.id.iv_answer);
            mTvAnswerName = (TextView) rootView.findViewById(R.id.tv_answer_name);
            mTvAnswer = (EmphasisTextView) rootView.findViewById(R.id.tv_answer);
            mTvCommentTime = (TextView) rootView.findViewById(R.id.tv_answer_time);
        }
    }
}
