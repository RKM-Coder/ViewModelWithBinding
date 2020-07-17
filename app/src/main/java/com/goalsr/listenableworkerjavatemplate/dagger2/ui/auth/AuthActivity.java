package com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.MainDaggerActivity;
import com.goalsr.listenableworkerjavatemplate.dagger2.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {
   /* @Inject
    String toMakeMsg;
    @Inject
    boolean isApprunning;*/

   EditText editText;

   private AuthViewModel authViewModel;

   @Inject
   ViewModelProviderFactory factory;

   @Inject
    Drawable logoimage;
   @Inject
    RequestManager requestManager;
    private String TAG="wwwwww";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        editText=findViewById(R.id.user_id_input);
        progressBar=findViewById(R.id.progress_bar);
        findViewById(R.id.login_button).setOnClickListener(this);
        authViewModel= ViewModelProviders.of(this,factory).get(AuthViewModel.class);
        setLogo();
        //Log.e("OUT",toMakeMsg+" Application running"+isApprunning);
        subscribeObserver();
    }

    public void subscribeObserver(){
       /* authViewModel.getObserVerResponse().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                if (userResponse!=null){
                    Log.d(TAG, "onChanged: "+userResponse);
                }
            }
        });*/

       authViewModel.getObserVerResponse().observe(this, new Observer<AuthResource<UserResponse>>() {
           @Override
           public void onChanged(AuthResource<UserResponse> userResponseAuthResource) {
               if (userResponseAuthResource!=null){
                   switch (userResponseAuthResource.status){
                       case LOADING: {
                           showingProgressBar(true);
                           break;
                       }
                       case AUTHENTICATED:{
                           showingProgressBar(false);
                           onLoginSuccess();
                           Log.d(TAG, "onChanged: "+userResponseAuthResource.data);
                           break;
                       }
                       case ERROR:{
                           showingProgressBar(false);
                           Toast.makeText(AuthActivity.this,"errror",Toast.LENGTH_LONG).show();
                           break;
                       }
                       case NOT_AUTHENTICATED:{
                           showingProgressBar(false);
                           Toast.makeText(AuthActivity.this,"Not Auth",Toast.LENGTH_LONG).show();
                           break;
                       }
                   }
               }
           }
       });
    }

    private void onLoginSuccess(){
        Intent intent=new Intent(this, MainDaggerActivity.class);
        startActivity(intent);
        finish();
    }

    private void showingProgressBar(boolean isVisible){
        if (isVisible){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
    public void setLogo(){

        requestManager.load(logoimage)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.login_button:{
               attemptLogin();
               break;
           }
       }
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(editText.getText().toString())){
            return;
        }
        if (!TextUtils.isDigitsOnly(editText.getText().toString())) return;

        authViewModel.authUserById(Integer.parseInt(editText.getText().toString()));
    }
}
