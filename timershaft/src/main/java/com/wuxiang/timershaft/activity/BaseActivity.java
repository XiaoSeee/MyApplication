package com.wuxiang.timershaft.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wuxiang.timershaft.R;

public abstract class BaseActivity extends AppCompatActivity {
    private TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initBaseView();
        initView();
    }

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected abstract int getContentView();

    protected abstract void initView();

    public void initBaseView() {
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
    }

    public void setTitle(String title) {
        mToolbarTitle.setText(title);
    }
}
