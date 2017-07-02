package cn.foxnickel.enterpriselearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import static cn.foxnickel.enterpriselearning.R.id.bottomNavigationBar;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private Toolbar mToolbar;
    private BottomNavigationBar mBottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setSupportActionBar(mToolbar);

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
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
