package cn.foxnickel.enterpriselearning.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.R;
import cn.foxnickel.enterpriselearning.fragment.subfragment.CourseContentFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    List<String> mFirstClassificationNameList;

    public CoursesFragment() {
        // Required empty public constructor
    }

    public static CoursesFragment newInstance() {
        return new CoursesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_courses, container, false);
        initView();
        mFirstClassificationNameList = new ArrayList<>();
        mFirstClassificationNameList.add("技术分享");
        mFirstClassificationNameList.add("项目管理");
        mFirstClassificationNameList.add("流程管理");

        initFragment(0);
        return mRootView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_first_classification);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        FirstClassificationAdapter firstClassificationAdapter = new FirstClassificationAdapter();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(firstClassificationAdapter);
    }

    private void initFragment(int position) {
        Bundle args = new Bundle();
        args.putString("firstClassificationName", mFirstClassificationNameList.get(position));
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.chapter_content, CourseContentFragment.newInstance(args));
        transaction.commit();
    }

    class FirstClassificationAdapter extends RecyclerView.Adapter<FirstClassificationAdapter.ViewHolder> {

        private int selectedPos = 0;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_item_first_classification, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.itemView.setSelected(selectedPos == position);
            holder.mTextView.setText(mFirstClassificationNameList.get(position));
            final int pos = holder.getAdapterPosition();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyItemChanged(selectedPos);
                    selectedPos = pos;
                    notifyItemChanged(selectedPos);
                    Bundle args = new Bundle();
                    args.putString("firstClassificationName", mFirstClassificationNameList.get(pos));
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.chapter_content, CourseContentFragment.newInstance(args));
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mFirstClassificationNameList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView mTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.tv_first_classification);
            }
        }
    }

}
