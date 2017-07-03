package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.foxnickel.enterpriselearning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseContentFragment extends Fragment {

    private String firstClassification;
    private View mRootView;

    public CourseContentFragment() {
        // Required empty public constructor
    }

    public static CourseContentFragment newInstance(Bundle args) {

        CourseContentFragment fragment = new CourseContentFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_course_content, container, false);
        Bundle args = getArguments();
        TextView textView = (TextView) mRootView.findViewById(R.id.tv_first_classification_name);
        textView.setText(args.getString("firstClassificationName") + " · 精选好课");

        return mRootView;
    }

}
