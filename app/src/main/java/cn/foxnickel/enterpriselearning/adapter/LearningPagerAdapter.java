package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class LearningPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private Context mContext;
    private String[] mPagerTitles = {"我的课程", "我的考试"};

    public LearningPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, Context context) {
        super(fm);
        mFragmentList = fragmentList;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerTitles[position];
    }
}
