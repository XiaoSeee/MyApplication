package com.wuxiang.timershaft.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.adapter.MainPagerAdapter;

/**
 * Created by Xiang on 2015/8/21.
 * 首界面
 */
public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {
    private TabLayout mTopTable;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    public Context mContext;

    @Override
    protected int getContentView() {
        return R.layout.main_layout;
    }

    @Override
    protected void initView() {
        mContext = getApplicationContext();
        initToolBar();
        initTab();
    }

    private void initTab() {
        mViewPager = findView(R.id.main_pager);
        PagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), mContext);
        mViewPager.setAdapter(adapter);

        mTopTable = findView(R.id.main_tab);
        mTopTable.setupWithViewPager(mViewPager);

    }


    private void initToolBar() {
        mToolbar = findView(R.id.main_toolbar);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.inflateMenu(R.menu.main_menu);
        mToolbar.setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_toolbar_add:
                break;
            default:
                break;
        }
        return true;
    }
}
