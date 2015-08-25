package com.wuxiang.timershaft.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.fragment.AlarmFragment;
import com.wuxiang.timershaft.fragment.SettingFragment;
import com.wuxiang.timershaft.fragment.TimeDownFragment;
import com.wuxiang.timershaft.fragment.TimeUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lizixuan on 2015/8/23.
 * 主界面的Pager实现
 * 1.时钟+闹钟界面
 * 2.天数统计界面
 * 3.倒计时界面
 * 4.设置界面
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTitles;
    private Context context;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

        tabTitles = context.getResources().getStringArray(R.array.title_list);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return AlarmFragment.newInstance(position + 1);
        } else {
            return TimeDownFragment.newInstance(position + 1);
        }


    }

}
