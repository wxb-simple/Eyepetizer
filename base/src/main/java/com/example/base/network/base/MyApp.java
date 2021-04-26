package com.example.base.network.base;

import android.app.Application;
import android.content.Context;

/**
 * create by libo
 * create on 2020/8/4
 * description Application
 */
public class MyApp extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
