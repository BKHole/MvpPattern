package com.taomi.mvppattern.application;

import android.content.Context;

import com.taomi.mvppattern.constant.UrlContainer;
import com.taomi.mvppattern.network.RxRetrofit;
import com.taomi.mvppattern.utils.PreUtils;

/**
 * app config
 */

public class AppConfig {

    static void init(Context context){
        //初始化网络框架
        RxRetrofit.getInstance().initRxRetrofit(context, UrlContainer.baseUrl);
        //初始化缓存
        PreUtils.init(context);
    }

}
