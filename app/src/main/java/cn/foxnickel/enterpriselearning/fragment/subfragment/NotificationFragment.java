package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.NotificationRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.Notification;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<Notification> mNotificationList;

    public NotificationFragment() {
        // Required empty public constructor
    }

    public static NotificationFragment newInstance() {

        return new NotificationFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_notification, container, false);

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_notification);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mNotificationList = new ArrayList<>();
        mNotificationList.add(new Notification("您的“新员工入职考试”即将关闭，请尽快完成该考试", "2017-07-18 10:00"));
        mNotificationList.add(new Notification("您的“新员工入职考试”即将关闭，请尽快完成该考试", "2017-07-15 10:00"));
        mNotificationList.add(new Notification("您的“新员工入职考试”已发布，请尽快完成该考试", "2017-07-13 10:00"));
        mNotificationList.add(new Notification("欢迎您使用rainbow企业学习平台，如有任何问题或建议可通过[意见反馈]给我们", "2017-07-05 10:00"));
        NotificationRecyclerAdapter notificationRecyclerAdapter = new NotificationRecyclerAdapter(getContext(), mNotificationList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(notificationRecyclerAdapter);

        return mRootView;
    }

}
