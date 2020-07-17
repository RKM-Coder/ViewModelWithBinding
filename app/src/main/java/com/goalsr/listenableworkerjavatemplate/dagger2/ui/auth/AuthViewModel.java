package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private final String TAG="SSSSSSSSSSSSSS";

    private final AuthApi authApi;
    MediatorLiveData<UserResponse> authUser=new MediatorLiveData<>();

    public LiveData<UserResponse> getObserVerResponse(){
        return authUser;
    }

    public void authUserById(int userId){
        final LiveData<UserResponse> source= LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        );

        authUser.addSource(source, new androidx.lifecycle.Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                authUser.setValue(userResponse);
            }
        });
    }

    @Inject
    public AuthViewModel(AuthApi authApi) {

        this.authApi=authApi;
        Log.e(TAG,"viewmodel created");
        if (this.authApi!=null){
            Log.d(TAG, "AuthViewModel: authapi not null");
        }else {
            Log.d(TAG, "AuthViewModel: auth api null");
        }
        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d(TAG, "onSubscribe: yyyy");
                    }

                    @Override
                    public void onNext(UserResponse userResponse) {

                        Log.d(TAG, "onNext: "+userResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onNext: "+e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: done");
                    }
                });
    }
}
