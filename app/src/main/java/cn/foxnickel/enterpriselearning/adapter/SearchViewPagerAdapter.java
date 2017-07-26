package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by NickelFox on 17/7/4.
 */

public class SearchViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] mPagerTitles = {"课程", "任务", "计划", "培训", "笔记"};
    private List<Fragment> mFragmentList;

    public SearchViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList) {
        super(fm);
        mContext = context;
        mFragmentList = fragmentList;
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
}
