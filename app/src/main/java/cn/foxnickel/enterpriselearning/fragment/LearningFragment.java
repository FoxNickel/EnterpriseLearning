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
public class LearningFragment extends Fragment {

    private static LearningFragment mLearningFragment;

    public LearningFragment() {
        // Required empty public constructor
    }

    public static LearningFragment newInstance() {

        if (mLearningFragment == null)
            mLearningFragment = new LearningFragment();

        return mLearningFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning, container, false);
    }

}
