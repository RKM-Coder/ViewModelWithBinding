package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.BaseActivity;

public class MainDaggerActivity extends BaseActivity {
    private String TAG="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dagger);
    }
}
