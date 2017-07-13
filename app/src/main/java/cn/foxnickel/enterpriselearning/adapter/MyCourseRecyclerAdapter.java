package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.SpecificCouseActivity;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class MyCourseRecyclerAdapter extends RecyclerView.Adapter<MyCourseRecyclerAdapter.ViewHolder> {

    private Context mContext;

    public MyCourseRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_my_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCourseName.setText("Java-从入门到放弃");
        holder.mCoursePic.setImageResource(R.drawable.login_bg2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, SpecificCouseActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCourseName;
        private ImageView mCoursePic;

        public ViewHolder(View itemView) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(R.id.tv_course_name);
            mCoursePic = (ImageView) itemView.findViewById(R.id.iv_course_pic);
        }
    }
}
