package com.taomi.mvppattern.application;

import android.content.Context;

/**
 * 上下文Context
 */

public class AppContext {
    private static Context mContext;
    private static AppContext mInstance;


    private AppContext(Context mCon) {
        mContext = mCon;
    }

    public static Context getContext() {
        return mContext;
    }

    public static AppContext getInstance() {
        return mInstance;
    }

    static void initialize(Context context) {
        if (mInstance == null) {
            synchronized (AppContext.class) {
                if (mInstance == null) {
                    mInstance = new AppContext(context.getApplicationContext());
                    AppConfig.init(mContext);
                }
            }
        }
    }
}
