package com.goalsr.listenableworkerjavatemplate.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthActivity;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private String TAG="baseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void subscriberObserver(){

        sessionManager.getUser().observe(this, new Observer<AuthResource<UserResponse>>() {
            @Override
            public void onChanged(AuthResource<UserResponse> userResponseAuthResource) {
                if (userResponseAuthResource!=null){
                    switch (userResponseAuthResource.status){
                        case LOADING: {

                            break;
                        }
                        case AUTHENTICATED:{

                            Log.d(TAG, "onChanged: "+userResponseAuthResource.data);
                            break;
                        }
                        case ERROR:{

                            break;
                        }
                        case NOT_AUTHENTICATED:{

                            navigateScreen();
                            break;
                        }
                    }
                }
            }
        });
    }

    public void navigateScreen(){
        Intent intent=new Intent(this,AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
