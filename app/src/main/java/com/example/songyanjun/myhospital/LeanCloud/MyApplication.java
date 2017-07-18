package com.example.songyanjun.myhospital.LeanCloud;

/**
 * Created by Lenovo on 2017/7/10.
 */

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"lS0H225YpSByDrqd2glmPlpy-gzGzoHsz", "yLEEh7Snchj70U1QTLLdkMF9");
        AVOSCloud.setDebugLogEnabled(true);
    }
}