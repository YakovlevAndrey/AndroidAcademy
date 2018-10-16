package com.example.androidacademy.ui.base;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.content.pm.PackageManager.*;

public abstract class BaseActivity extends AppCompatActivity {

    public boolean isImplicitIntentSave(final Intent intent) {
        return getPackageManager().queryIntentActivities(intent, MATCH_DEFAULT_ONLY).size() > 0;
    }

    public void showToast(@StringRes int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

}
