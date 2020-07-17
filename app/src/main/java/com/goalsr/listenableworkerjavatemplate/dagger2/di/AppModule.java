package com.goalsr.listenableworkerjavatemplate.dagger2.di;


import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.utils.Constante;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constante.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
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
    @Singleton
    @Provides
    static RequestOptions provideRequestOption(){
        return RequestOptions.placeholderOf(R.mipmap.ic_splash_logo)
                .error(R.mipmap.mp_3);

    }
    @Singleton
    @Provides
    static RequestManager provideRequestManager(Application application,RequestOptions options){
        return Glide.with(application)
                .applyDefaultRequestOptions(options);
    }
    @Singleton
    @Provides
    static Drawable provideAppDrawable(Application application){
         return ContextCompat.getDrawable(application,R.mipmap.ic_splash_logo);
    }
}
