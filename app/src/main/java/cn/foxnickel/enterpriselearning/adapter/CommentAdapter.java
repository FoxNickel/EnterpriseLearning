/**
 * Created by Night on 2017/7/15.
 * Desc:
 */
package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;
import cn.foxnickel.enterpriselearning.WriteCommentActivity;
import cn.foxnickel.enterpriselearning.utils.ScreenUtil;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * @author Night
 * @since 2017-07-16
 */
public class CommentAdapter extends AnimRecyclerViewAdapter<CommentAdapter.ViewHolder> {
    private final Context context;
    //popupwindow组件
    private LayoutInflater mLayoutInflater;
    View popupView;
    PopupWindow popupWindow;
    private final Button mBtReply;
    private final int density;

    public CommentAdapter(final Context context) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = mLayoutInflater.inflate(R.layout.popupwindow_comment, null);
        mBtReply = (Button) popupView.findViewById(R.id.bt_reply);

        density = (int) ScreenUtil.getDeviceDensity(context);
        popupWindow = new PopupWindow(popupView, 104 * density, 64 * density);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
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

    class ViewHolder extends RecyclerView.ViewHolder {
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
            mBtReply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SpecificCouseActivity.mVpPlayer.onVideoPause();
                    context.startActivity(new Intent(context, WriteCommentActivity.class)
                            .putExtra("hint", "回复 " + mTvAnswerName.getText().toString().trim()));
                }
            });
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int location[] = new int[2];
                    v.getLocationInWindow(location);
                    popupWindow.showAtLocation(
                            v,
                            Gravity.NO_GRAVITY,
                            location[0] + 240 * density,
                            location[1] + 64 * density);
                }
            });
        }
    }
}
