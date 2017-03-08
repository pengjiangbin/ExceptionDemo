package com.padoon.exceptiondemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by jiang on 2017/3/8.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
