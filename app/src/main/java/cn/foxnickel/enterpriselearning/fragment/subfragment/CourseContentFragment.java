package cn.foxnickel.enterpriselearning.fragment.subfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
    List<String> secondClassificationNameList;
    List<List<String>> thirdClassificationNameList;
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
        String firstClassificationName = args.getString("firstClassificationName");
        textView.setText(firstClassificationName + " · 精选好课");
        View courseRankView = mRootView.findViewById(R.id.courses_rank);
        int bgPicId = args.getInt("bg_pic");
        courseRankView.setBackgroundResource(bgPicId);
        List<String> list = new ArrayList<>();
        secondClassificationNameList = new ArrayList<>();
        thirdClassificationNameList = new ArrayList<>();
        if (TextUtils.equals(firstClassificationName, "技术分享")) {
            technology(list);
        } else if (TextUtils.equals(firstClassificationName, "项目管理")) {
            projectManagement(list);
        } else {
            processManagement(list);
        }
        initView();

        return mRootView;
    }

    private void processManagement(List<String> list) {
        secondClassificationNameList.add("流程管理系列");

        list.add("流程管理层次");
        list.add("流程管理思路");
        list.add("流程管理模式");
        list.add("职能管理模式");
        list.add("流程建模规范");
        list.add("流程管理优化");
        list.add("制度与平台管理");
        thirdClassificationNameList.add(list);
    }

    private void projectManagement(List<String> list) {
        secondClassificationNameList.add("项目管理系列");

        list.add("项目风险管理");
        list.add("项目范围管理");
        list.add("项目质量管理");
        list.add("项目成本管理");
        list.add("项目计划");
        list.add("项目执行");
        list.add("项目结束");
        list.add("项目管理十大模板");
        list.add("项目管理工具与技巧");
        thirdClassificationNameList.add(list);
    }

    private void technology(List<String> list) {
        secondClassificationNameList.add("通用技术");
        secondClassificationNameList.add("专业技术");

        list.add("Python");
        list.add("PHP");
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("C#");
        list.add("HTML/CSS");
        list.add("Swift");
        list.add("Git");
        list.add("R");
        list.add("JavaScript");
        thirdClassificationNameList.add(list);
        list = new ArrayList<>();
        list.add("防抖技术");
        list.add("全景技术");
        list.add("人脸技术");
        list.add("HDR技术");
        list.add("暗光高清拍摄技术");
        list.add("手势识别技术");
        list.add("3D立体成像技术");
        list.add("场景检测与物体识别技术");
        list.add("AR/VR技术");
        thirdClassificationNameList.add(list);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_second_classification);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        SecondClassificationAdapter secondClassificationAdapter = new SecondClassificationAdapter(secondClassificationNameList, thirdClassificationNameList, getContext());
        mRecyclerView.setAdapter(secondClassificationAdapter);
    }

}
