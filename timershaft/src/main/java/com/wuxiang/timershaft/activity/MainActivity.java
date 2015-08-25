package com.wuxiang.timershaft.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.adapter.MainPagerAdapter;
import com.wuxiang.timershaft.util.Utils;

import java.util.List;

/**
 * Created by Xiang on 2015/8/21.
 * 首界面
 */
public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {
    private TabLayout mTopTable;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    public Context mContext;
    private String[] mTitleList;

    @Override
    protected int getContentView() {
        return R.layout.main_layout;
    }

    @Override
    protected void initView() {
        mContext = getApplicationContext();
        mTitleList = getResources().getStringArray(R.array.title_list);
        initToolBar();
        initTab();
    }

    private void initTab() {
        mViewPager = findView(R.id.main_pager);
        mTopTable = findView(R.id.main_tab);

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), mContext);
        mViewPager.setAdapter(adapter);
        mTopTable.setupWithViewPager(mViewPager);


        mTopTable.removeAllTabs();
        mTopTable.addTab(mTopTable.newTab().setIcon(R.drawable.tab_alarm_ic));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.drawable.tab_alarm_ic));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.drawable.tab_alarm_ic));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.drawable.tab_alarm_ic));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                onPageChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void onPageChange(int position) {
        setTitle(mTitleList[position]);
        if (position == 3) {
            mToolbar.getMenu().getItem(0).setVisible(false);
        } else {
            mToolbar.getMenu().getItem(0).setVisible(true);
        }
    }


    private void initToolBar() {
        mToolbar = findView(R.id.main_toolbar);
        setTitle(mTitleList[0]);
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
