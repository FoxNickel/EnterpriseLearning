package cn.foxnickel.enterpriselearning.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by NickelFox on 2017/7/5.
 */

public class SpecificCoursePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private Context mContext;
    private String[] mPagerTitles = {"章节", "详情", "评论", "问答"};

    public SpecificCoursePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, Context context) {
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
