package com.example.androidacademy.ui.base.activity;

import android.content.Intent;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.androidacademy.R;
import com.example.androidacademy.utils.SystemConfiguration;

import static android.content.pm.PackageManager.*;

public abstract class BaseActivity extends AppCompatActivity {

    protected final static int EXTRA_INT_DEFAULT = Integer.MIN_VALUE;

    protected Toolbar toolbar;

    public float getDimension(@DimenRes int resId) {
        return getResources().getDimension(resId);
    }

    public SystemConfiguration.Orientation getScreenOrientation() {
        return SystemConfiguration.getOrientation(this);
    }

    public void initToolbar(int toolbarId) {
        toolbar = findViewById(toolbarId);
        setSupportActionBar(toolbar);
    }

    public void toolbarSetTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public boolean intExtraIsSet(int val){
        return val != EXTRA_INT_DEFAULT;
    }

    public boolean intExtraIsSet(int val, int defaultVal){
        return val != defaultVal;
    }


    public boolean isImplicitIntentSave(final Intent intent) {
        return getPackageManager().queryIntentActivities(intent, MATCH_DEFAULT_ONLY).size() > 0;
    }

    public void showToast(@StringRes int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

}
