package cn.foxnickel.enterpriselearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import cn.foxnickel.enterpriselearning.fragment.CoursesFragment;
import cn.foxnickel.enterpriselearning.fragment.LearningFragment;
import cn.foxnickel.enterpriselearning.fragment.MainPageFragment;
import cn.foxnickel.enterpriselearning.fragment.ProfileFragment;

import static cn.foxnickel.enterpriselearning.R.id.bottomNavigationBar;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private Toolbar mToolbar;
    private BottomNavigationBar mBottomNavigationBar;
    private MainPageFragment mMainPageFragment;
    private CoursesFragment mCoursesFragment;
    private LearningFragment mLearningFragment;
    private ProfileFragment mProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setSupportActionBar(mToolbar);

        initBottomNavBar();
        initTab();
    }

    private void initTab() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mMainPageFragment == null) {
            mMainPageFragment = MainPageFragment.newInstance();
        }
        transaction.replace(R.id.content_main, mMainPageFragment);
        transaction.commit();
    }

    private void initBottomNavBar() {
        mBottomNavigationBar.setBarBackgroundColor(R.color.colorAccent);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);//适应大小

        mBottomNavigationBar.addItem(new BottomNavigationItem(
                R.drawable.ic_home_red_24dp, getString(R.string.main_page))
                .setInactiveIconResource(R.drawable.ic_home_gray_24dp)
                .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(
                        R.drawable.ic_courses_red_24dp, getString(R.string.courses))
                        .setInactiveIconResource(R.drawable.ic_courses_gray_24dp)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(
                        R.drawable.ic_learning_red_24dp, getString(R.string.learning))
                        .setInactiveIconResource(R.drawable.ic_learning_gray_24dp)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(
                        R.drawable.ic_profile_red_24dp, getString(R.string.mine))
                        .setInactiveIconResource(R.drawable.ic_profile_gray_24dp)
                        .setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)//默认显示面板
                .initialise();//初始化
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(bottomNavigationBar);
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
            case R.id.action_notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                mToolbar.setTitle(getString(R.string.main_page));
                if (mMainPageFragment == null) {
                    mMainPageFragment = MainPageFragment.newInstance();
                }
                transaction.replace(R.id.content_main, mMainPageFragment);
                break;
            case 1:
                mToolbar.setTitle(getString(R.string.courses));
                if (mCoursesFragment == null) {
                    mCoursesFragment = CoursesFragment.newInstance();
                }
                transaction.replace(R.id.content_main, mCoursesFragment);
                break;
            case 2:
                mToolbar.setTitle(getString(R.string.learning));
                if (mLearningFragment == null) {
                    mLearningFragment = LearningFragment.newInstance();
                }
                transaction.replace(R.id.content_main, mLearningFragment);
                break;
            case 3:
                mToolbar.setTitle(getString(R.string.mine));
                if (mProfileFragment == null) {
                    mProfileFragment = ProfileFragment.newInstance();
                }
                transaction.replace(R.id.content_main, mProfileFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
