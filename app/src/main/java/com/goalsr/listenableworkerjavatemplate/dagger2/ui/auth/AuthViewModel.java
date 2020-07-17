package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.SessionManager;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private final String TAG="SSSSSSSSSSSSSS";

    private final AuthApi authApi;
   // MediatorLiveData<AuthResource<UserResponse>> authUser=new MediatorLiveData<>();

    SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi,SessionManager sessionManager) {

        this.authApi=authApi;
        this.sessionManager=sessionManager;


        /*Log.e(TAG,"viewmodel created");
        if (this.authApi!=null){
            Log.d(TAG, "AuthViewModel: authapi not null");
        }else {
            Log.d(TAG, "AuthViewModel: auth api null");
        }*/
       /* authApi.getUser(1)
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
                });*/
    }


    public LiveData<AuthResource<UserResponse>> getObserVerResponse(){
        return sessionManager.getUser();
    }



    private LiveData<AuthResource<UserResponse>> queryUserId(int userId){
        LiveData<AuthResource<UserResponse>> source= LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                        .onErrorReturn(new Function<Throwable, UserResponse>() {
                            @Override
                            public UserResponse apply(Throwable throwable) throws Exception {
                                UserResponse erroruserResponse=new UserResponse();
                                erroruserResponse.setId(-1);
                                return erroruserResponse;
                            }
                        })
                        .map(new Function<UserResponse, AuthResource<UserResponse>>() {
                            @Override
                            public AuthResource<UserResponse> apply(UserResponse userResponse) throws Exception {
                                if (userResponse.getId()==-1){
                                    return AuthResource.error("ERROR",(UserResponse)null);
                                }
                                return AuthResource.authenticated(userResponse);
                            }
                        })
                        .subscribeOn(Schedulers.io())
        );
        return source;
    }

    public void authUserById(int userId){
       // authUser.setValue(AuthResource.loading((UserResponse)null));
        //final
        sessionManager.authenticateUserById(queryUserId(userId));

        /*authUser.addSource(source, new androidx.lifecycle.Observer<AuthResource<UserResponse>>() {
            @Override
            public void onChanged(AuthResource<UserResponse> userResponse) {
                authUser.setValue(userResponse);
                authUser.removeSource(source);
            }
        });*/

//       authUser.addSource(source);
    }
}
