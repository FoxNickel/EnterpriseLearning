package cn.foxnickel.enterpriselearning.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.LearningPagerAdapter;
import cn.foxnickel.enterpriselearning.fragment.subfragment.MyCourseFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.MyExamFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearningFragment extends Fragment {

    private View mRootView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public LearningFragment() {
        // Required empty public constructor
    }

    public static LearningFragment newInstance() {
        return new LearningFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_learning, container, false);
        mViewPager = (ViewPager) mRootView.findViewById(R.id.view_pager_learning);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(MyCourseFragment.newInstance());
        fragmentList.add(MyExamFragment.newInstance());
        LearningPagerAdapter learningPagerAdapter = new LearningPagerAdapter(getChildFragmentManager(), fragmentList, getContext());
        mViewPager.setAdapter(learningPagerAdapter);
        mTabLayout = (TabLayout) mRootView.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);


        return mRootView;
    }

}
