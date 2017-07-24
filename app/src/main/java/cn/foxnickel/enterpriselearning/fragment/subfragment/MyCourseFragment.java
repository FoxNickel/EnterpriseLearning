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
import cn.foxnickel.enterpriselearning.adapter.MyCourseRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Course;

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
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Java-从入门到精通", Integer.toString(R.drawable.java1), 4));
        courseList.add(new Course("Android网络与数据存储", Integer.toString(R.drawable.android2), 5));
        courseList.add(new Course("Python自动化运维篇", Integer.toString(R.drawable.python1), 4));
        courseList.add(new Course("Java面向对象", Integer.toString(R.drawable.java2), 4));
        courseList.add(new Course("Python装饰器", Integer.toString(R.drawable.python2), 4));
        MyCourseRecyclerAdapter myCourseRecyclerAdapter = new MyCourseRecyclerAdapter(getContext(), courseList);
        mRecyclerView.setAdapter(myCourseRecyclerAdapter);
        mSwipeRefresh = (SwipeRefreshLayout) mRootView.findViewById(R.id.course_swipe_refresh);
    }
}
