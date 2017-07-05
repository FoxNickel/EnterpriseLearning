package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.MyCourseRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCourseFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View view;
    private SwipeRefreshLayout mSwipeRefresh;

    public MyCourseFragment() {
        // Required empty public constructor
    }

    public static MyCourseFragment newInstance() {

        return new MyCourseFragment();
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
        MyCourseRecyclerAdapter myCourseRecyclerAdapter = new MyCourseRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(myCourseRecyclerAdapter);
        mSwipeRefresh = (SwipeRefreshLayout) mRootView.findViewById(R.id.swipe_refresh);
    }
}
