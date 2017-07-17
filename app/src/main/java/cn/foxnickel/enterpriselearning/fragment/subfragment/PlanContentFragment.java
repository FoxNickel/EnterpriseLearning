package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.PlanContentRecyclerAdapter;
import cn.foxnickel.enterpriselearning.bean.StudyPlanning;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanContentFragment extends Fragment {

    private String firstClassification;
    private View mRootView;
    List<String> secondClassificationNameList, thirdClassificationNameList;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<StudyPlanning> mStudyPlanningList;
    public PlanContentFragment() {
        // Required empty public constructor
    }

    public static PlanContentFragment newInstance(Bundle args) {

        PlanContentFragment fragment = new PlanContentFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_my_exam, container, false);
        Bundle args = getArguments();//根据传来的args选择adapter的数据
        initView();
        return mRootView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_my_exam);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        PlanContentRecyclerAdapter planContentRecyclerAdapter = new PlanContentRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(planContentRecyclerAdapter);
    }

}
