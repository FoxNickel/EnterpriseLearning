package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.foxnickel.enterpriselearning.adapter.NotificationViewPagerAdapter;
import cn.foxnickel.enterpriselearning.fragment.subfragment.NotificationFragment;
import cn.foxnickel.enterpriselearning.fragment.subfragment.PrivateLetterFragment;

import static cn.foxnickel.enterpriselearning.R.id.toolbar;

public class NotificationActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.view_pager_notification);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(NotificationFragment.newInstance());
        fragmentList.add(PrivateLetterFragment.newInstance());
        NotificationViewPagerAdapter notificationViewPagerAdapter = new NotificationViewPagerAdapter(getSupportFragmentManager(), this, fragmentList);
        mViewPager.setAdapter(notificationViewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
