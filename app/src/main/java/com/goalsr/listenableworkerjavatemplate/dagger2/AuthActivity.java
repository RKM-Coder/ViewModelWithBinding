package com.goalsr.listenableworkerjavatemplate.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.goalsr.listenableworkerjavatemplate.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {
   /* @Inject
    String toMakeMsg;
    @Inject
    boolean isApprunning;*/

   @Inject
    Drawable logoimage;
   @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setLogo();
        //Log.e("OUT",toMakeMsg+" Application running"+isApprunning);
    }

    public void setLogo(){

        requestManager.load(logoimage)
                .into((ImageView)findViewById(R.id.login_logo));
    }
}
