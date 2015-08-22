package com.wuxiang.timershaft;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.meizu.flyme.reflect.StatusBarProxy;

/**
 * Created by Xiang on 2015/8/21.
 * 首界面
 */
public class MainActivity extends Activity {
    public TabLayout mTopTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //魅族设置状态栏图标文字为深色
        StatusBarProxy.setStatusBarDarkIcon(getWindow(), true);
        mTopTable = (TabLayout) findViewById(R.id.main_tab);
        mTopTable.addTab(mTopTable.newTab().setIcon(R.mipmap.ic_alarm_black));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.mipmap.ic_alarm_black));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.mipmap.ic_alarm_black));
        mTopTable.addTab(mTopTable.newTab().setIcon(R.mipmap.ic_alarm_black));
        //测试没有代理能否提交
    }
}
