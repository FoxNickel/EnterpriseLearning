package cn.foxnickel.enterpriselearning.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.foxnickel.enterpriselearning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPageFragment extends Fragment {

    private static MainPageFragment mMainPageFragment;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

}
