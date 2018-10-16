package com.example.androidacademy.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;


public class SystemConfiguration {

    private SystemConfiguration(){}

    public static Orientation getOrientation(final @NonNull Context context){
        int orientation = context.getResources().getConfiguration().orientation;
        return orientation == Configuration.ORIENTATION_PORTRAIT ? Orientation.PORTRAIT : Orientation.LANDSCAPE;
    }

    public enum Orientation{
        LANDSCAPE, PORTRAIT
    }

}
