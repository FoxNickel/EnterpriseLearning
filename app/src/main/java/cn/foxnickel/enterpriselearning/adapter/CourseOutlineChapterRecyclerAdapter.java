/**
 * Created by Night on 2017/7/12.
 * Desc:
 */
package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

import static cn.foxnickel.enterpriselearning.CourseActivity.mButton;
import static cn.foxnickel.enterpriselearning.CourseActivity.wm;

/**
 * @author Night
 * @since 2017-07-12
 */
public class CourseOutlineChapterRecyclerAdapter extends RecyclerView.Adapter<CourseOutlineChapterRecyclerAdapter.ViewHolder> {
    private final Context context;
    private List<String> items;


    public CourseOutlineChapterRecyclerAdapter(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_course_outline_chapter, null, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = items.get(position);
        holder.mTvChapterName.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        private ImageView mIvStop;
        private TextView mTvChapterName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            mIvStop = (ImageView) rootView.findViewById(R.id.iv_stop);
            mTvChapterName = (TextView) rootView.findViewById(R.id.tv_chapter_name);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wm.removeView(mButton);
                    mButton = null;
                    ((AppCompatActivity) context).finish();
                    context.startActivity(new Intent(context, SpecificCouseActivity.class));
                }
            });
        }
    }
}
