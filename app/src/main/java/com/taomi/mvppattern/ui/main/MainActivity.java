package com.taomi.mvppattern.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.taomi.mvppattern.R;
import com.taomi.mvppattern.ui.base.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean initToolbar() {
        return false;
    }

    @Override
    protected void getIntent(Intent intent) {

    }

    @Override
    protected void initViews() {

    }
}
