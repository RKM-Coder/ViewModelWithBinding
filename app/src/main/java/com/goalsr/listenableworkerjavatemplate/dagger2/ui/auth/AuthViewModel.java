package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private final String TAG="SSSSSSSSSSSSSS";

    private final AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi) {

        this.authApi=authApi;
        Log.e(TAG,"viewmodel created");
        if (this.authApi!=null){
            Log.d(TAG, "AuthViewModel: authapi not null");
        }else {
            Log.d(TAG, "AuthViewModel: auth api null");
        }
    }
}
