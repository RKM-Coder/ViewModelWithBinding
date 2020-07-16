package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
   /* @Inject
    String toMakeMsg;
    @Inject
    boolean isApprunning;*/

   private AuthViewModel authViewModel;

   @Inject
   ViewModelProviderFactory factory;

   @Inject
    Drawable logoimage;
   @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        authViewModel= ViewModelProviders.of(this,factory).get(AuthViewModel.class);
        setLogo();
        //Log.e("OUT",toMakeMsg+" Application running"+isApprunning);
    }

    public void setLogo(){

        requestManager.load(logoimage)
                .into((ImageView)findViewById(R.id.login_logo));
    }
}
