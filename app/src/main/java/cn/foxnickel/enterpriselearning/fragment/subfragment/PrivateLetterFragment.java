package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.PrivateLetterRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrivateLetterFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    public PrivateLetterFragment() {
        // Required empty public constructor
    }

    public static PrivateLetterFragment newInstance() {

        return new PrivateLetterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_private_letter, container, false);

        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_private_letter);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        PrivateLetterRecyclerAdapter privateLetterRecyclerAdapter = new PrivateLetterRecyclerAdapter(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(privateLetterRecyclerAdapter);

        return mRootView;
    }

}
