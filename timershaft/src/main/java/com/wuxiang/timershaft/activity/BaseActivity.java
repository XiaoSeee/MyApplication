package com.wuxiang.timershaft.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
    }

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected abstract int getContentView();
    
    protected abstract void initView();

}
