package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.NoteRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Note;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchNoteFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View view;
    private SwipeRefreshLayout mSwipeRefresh;

    public SearchNoteFragment() {
        // Required empty public constructor
    }

    public static SearchNoteFragment newInstance() {

        return new SearchNoteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_my_course, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_my_course);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        List<Note> mList = new ArrayList<>();
        mList.add(new Note("源自:web UI设计理论入门-网页是如何实现的", "web 标准化布局原理\n" +
                "把网页看成多个网格\n" +
                "先有行再有列（从上到下）\n" +
                "先做容器再做内容（从外到内）", "2017-07-10"));
        mList.add(new Note("源自:web UI设计理论入门-关于分辨率", "分辨率：水平和垂直像素个数", "2017-07-09"));
        mList.add(new Note("源自:web UI设计理论入门-webUI是什么", "UI的3个方向：\n" +
                "1.用户研究\n" +
                "2.交互设计\n" +
                "3.界面设计", "2017-07-08"));
        mList.add(new Note("源自:web UI设计理论入门-课程介绍", "ie9+、chrome、flex及主流浏览器都可兼容css3", "2017-07-07"));
        mList.add(new Note("源自:web UI设计理论入门-课程介绍", "ps里面有切片工具可以用来切图", "2017-07-07"));

        NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(getContext(), mList);

        mRecyclerView.setAdapter(noteRecyclerAdapter);
        mSwipeRefresh = (SwipeRefreshLayout) mRootView.findViewById(R.id.course_swipe_refresh);
    }
}
