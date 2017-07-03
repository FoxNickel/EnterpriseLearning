package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.adapter.SecondClassificationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseContentFragment extends Fragment {

    private String firstClassification;
    private View mRootView;
    List<String> secondClassificationNameList, thirdClassificationNameList;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

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

        secondClassificationNameList = new ArrayList<>();
        thirdClassificationNameList = new ArrayList<>();
        secondClassificationNameList.add("通用技术");
        secondClassificationNameList.add("专业技术");

        /*thirdClassificationNameList.add("Python");
        thirdClassificationNameList.add("PHP");
        thirdClassificationNameList.add("Java");
        thirdClassificationNameList.add("C");
        thirdClassificationNameList.add("c++");
        thirdClassificationNameList.add("C#");
        thirdClassificationNameList.add("HTML/CSS");
        thirdClassificationNameList.add("Swift");
        thirdClassificationNameList.add("Git");
        thirdClassificationNameList.add("R");
        thirdClassificationNameList.add("JavaScript");*/

        thirdClassificationNameList.add("防抖技术");
        thirdClassificationNameList.add("全景技术");
        thirdClassificationNameList.add("人脸技术");
        thirdClassificationNameList.add("HDR技术");
        thirdClassificationNameList.add("暗光高清拍摄技术");
        thirdClassificationNameList.add("手势识别技术");
        thirdClassificationNameList.add("3D立体成像技术");
        thirdClassificationNameList.add("场景检测与物体识别技术");
        thirdClassificationNameList.add("AR/VR技术");

        initView();

        return mRootView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_second_classification);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        SecondClassificationAdapter secondClassificationAdapter = new SecondClassificationAdapter(secondClassificationNameList, thirdClassificationNameList, getContext());
        mRecyclerView.setAdapter(secondClassificationAdapter);
    }

}
