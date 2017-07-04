package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.NotificationRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

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
        NotificationRecyclerAdapter notificationRecyclerAdapter = new NotificationRecyclerAdapter(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(notificationRecyclerAdapter);

        return mRootView;
    }

}
