package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.SessionManager;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager){
        this.sessionManager=sessionManager;
        Log.d(TAG, "ProfileFragment: viewmodel");

    }

    public LiveData<AuthResource<UserResponse>> getAuthUserDetails(){
        return sessionManager.getUser();
    }
}
