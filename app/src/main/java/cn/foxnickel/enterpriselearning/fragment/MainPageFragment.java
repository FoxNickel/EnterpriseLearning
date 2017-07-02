package cn.foxnickel.enterpriselearning.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.foxnickel.enterpriselearning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment {

    private static MainPageFragment mMainPageFragment;
    private View mRootView;
    private BGABanner mBGABanner;
    private Context mContext = getContext();

    public MainPageFragment() {
        // Required empty public constructor
    }

    public static MainPageFragment newInstance() {
        if (mMainPageFragment == null) {
            mMainPageFragment = new MainPageFragment();
        }
        return mMainPageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_page, container, false);
        initBanner();
        return mRootView;
    }

    private void initBanner() {
        mBGABanner = (BGABanner) mRootView.findViewById(R.id.banner);
        mBGABanner.setData(R.drawable.login_bg, R.drawable.login_bg2, R.drawable.login_bg3, R.drawable.login_bg4);
    }

}
