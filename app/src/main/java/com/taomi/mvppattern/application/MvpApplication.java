package com.taomi.mvppattern.application;

import android.app.Application;

public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化App配置
        AppContext.initialize(this);
    }

}
