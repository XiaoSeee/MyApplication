package com.wuxiang.timershaft.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.fragment.AlarmFragment;

import java.util.List;

/**
 * Created by Lizixuan on 2015/8/23.
 * 主界面的Pager实现
 * 1.时钟+闹钟界面
 * 2.天数统计界面
 * 3.倒计时界面
 * 4.设置界面
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Tab1", "Tab2", "Tab3", "Tab4"};
    private Context context;
    private int[] imageResId = {R.mipmap.ic_alarm_black, R.mipmap.ic_alarm_black,
            R.mipmap.ic_alarm_black, R.mipmap.ic_alarm_black};

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return tabTitles[position];
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }

    @Override
    public Fragment getItem(int position) {
        return AlarmFragment.newInstance(position + 1);
    }

}
