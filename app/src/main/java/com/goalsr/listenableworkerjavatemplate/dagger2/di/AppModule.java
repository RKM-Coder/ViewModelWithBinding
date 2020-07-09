package com.goalsr.listenableworkerjavatemplate.dagger2.di;


import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.goalsr.listenableworkerjavatemplate.R;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
   /* @Provides
    static String saySomething(){
        return "We are ready";
    }

    @Provides
    static boolean getApp(Application application){
        return application==null;
    }*/

    /*@Provides
    static boolean getStatus(){
        return true;
    }*/

    @Provides
    static RequestOptions provideRequestOption(){
        return RequestOptions.placeholderOf(R.mipmap.ic_splash_logo)
                .error(R.mipmap.mp_3);

    }

    @Provides
    static RequestManager provideRequestManager(Application application,RequestOptions options){
        return Glide.with(application)
                .applyDefaultRequestOptions(options);
    }

    @Provides
    static Drawable provideAppDrawable(Application application){
         return ContextCompat.getDrawable(application,R.mipmap.ic_splash_logo);
    }
}
