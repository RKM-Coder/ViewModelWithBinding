package com.goalsr.listenableworkerjavatemplate.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.goalsr.listenableworkerjavatemplate.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
    @Inject
    String toMakeMsg;
    @Inject
    boolean isApprunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Log.e("OUT",toMakeMsg+" Application running"+isApprunning);
    }
}
