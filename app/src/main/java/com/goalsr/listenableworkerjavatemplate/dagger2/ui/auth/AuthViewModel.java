package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private final String TAG="SSSSSSSSSSSSSS";

    @Inject
    public AuthViewModel() {

        Log.e(TAG,"viewmodel created");
    }
}
