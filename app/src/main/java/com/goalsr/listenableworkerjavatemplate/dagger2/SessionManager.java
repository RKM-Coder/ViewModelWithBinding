package com.goalsr.listenableworkerjavatemplate.dagger2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private String  TAG="ssss";
    private MediatorLiveData<AuthResource<UserResponse>> cacheUser=new MediatorLiveData<>();

    @Inject
    public SessionManager() {

    }

    public void authenticateUserById(LiveData<AuthResource<UserResponse>> source){
        if (cacheUser!=null){
            cacheUser.setValue(AuthResource.loading((UserResponse)null));

            cacheUser.addSource(source, new Observer<AuthResource<UserResponse>>() {
                @Override
                public void onChanged(AuthResource<UserResponse> userResponseAuthResource) {
                   /* if (userResponseAuthResource!=null){

                    }*/
                   cacheUser.setValue(userResponseAuthResource);
                   cacheUser.removeSource(source);
                }
            });
        }/*else {
            Log.d(TAG, "authenticateUserById: error  ");
        }*/

    }
    public void logout(){
        cacheUser.setValue(AuthResource.logout());
    }

    public LiveData<AuthResource<UserResponse>> getUser(){
        return cacheUser;
    }

}