package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.utils.FullyLinearLayoutManager;

/**
 * Created by Night on 2017/7/12.
 */

public class CourseOutlineRecyclerAdapter extends RecyclerView.Adapter<CourseOutlineRecyclerAdapter.ViewHolder> {

    private Context mContext;


    public CourseOutlineRecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_course_outline, parent, false);
        return new ViewHolder(view);
    }

    private List<String> mList = new ArrayList<String>();
    CourseOutlineChapterRecyclerAdapter chapterRecyclerAdapter;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTimeMarker.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker), ContextCompat.getColor(mContext, R.color.gray));
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(mContext);
        holder.mRvCourseChapter.setLayoutManager(linearLayoutManager);
        switch (position) {
            case 0:
                holder.mTvCourseChapterName.setText("Web UI设计课程简介");
                mList.add("1-1 课程介绍");
                chapterRecyclerAdapter = new CourseOutlineChapterRecyclerAdapter(mList, mContext);
                holder.mRvCourseChapter.setAdapter(chapterRecyclerAdapter);
                break;
            case 1:
                holder.mTvCourseChapterName.setText("从设计角度初识web页面");
                mList.clear();
                mList.add("2-1 webUI是什么");
                mList.add("2-2 关于分辨率");
                mList.add("2-3 web的基本分类");
                chapterRecyclerAdapter = new CourseOutlineChapterRecyclerAdapter(mList, mContext);
                holder.mRvCourseChapter.setAdapter(chapterRecyclerAdapter);
                break;
            case 2:
                holder.mTvCourseChapterName.setText("Web UI设计拆分详解");
                mList.clear();
                mList.add("3-1 设计维度");
                mList.add("3-2 界面设计流程");
                mList.add("3-3 基本规范");
                chapterRecyclerAdapter = new CourseOutlineChapterRecyclerAdapter(mList, mContext);
                holder.mRvCourseChapter.setAdapter(chapterRecyclerAdapter);
                break;
            case 3:
                holder.mTvCourseChapterName.setText("Web UI设计课程总结");
                mList.clear();
                mList.add("4-1 课程总结");
                chapterRecyclerAdapter = new CourseOutlineChapterRecyclerAdapter(mList, mContext);
                holder.mRvCourseChapter.setAdapter(chapterRecyclerAdapter);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getItemCount());
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TimelineView mTimeMarker;
        private TextView mTvCourseChapterName;
        private RecyclerView mRvCourseChapter;

        public ViewHolder(View itemView) {
            super(itemView);
            mTimeMarker = (TimelineView) itemView.findViewById(R.id.time_marker);
            mTvCourseChapterName = (TextView) itemView.findViewById(R.id.tv_course_chapter_name);
            mRvCourseChapter = (RecyclerView) itemView.findViewById(R.id.rv_course_chapter);
        }
    }
}
