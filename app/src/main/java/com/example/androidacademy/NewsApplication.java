package com.example.androidacademy;

import android.app.Application;

import com.example.androidacademy.utils.StringResWrapper;

public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StringResWrapper.init(this);
    }
}
