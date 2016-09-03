package com.example.jiang_yan.glidede;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jiang_yan on 2016/9/3.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
