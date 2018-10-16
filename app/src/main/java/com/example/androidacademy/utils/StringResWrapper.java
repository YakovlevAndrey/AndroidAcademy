package com.example.androidacademy.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.lang.ref.WeakReference;

public class StringResWrapper {

    private static WeakReference<Context> contextRef;
    private final static StringResWrapper instance = new StringResWrapper();

    private StringResWrapper() {
    }

    public synchronized static void init(final Context context) {
        contextRef = new WeakReference<>(context);
    }

    public static StringResWrapper getInstance() {
        return instance;
    }

    @NonNull
    public String getString(@StringRes final int resId) {
        return getContext().getString(resId);
    }

    @NonNull
    private Context getContext() throws IllegalStateException {
        if (contextRef == null || contextRef.get() == null)
            throw new IllegalStateException("call init method");
        return contextRef.get();
    }

}