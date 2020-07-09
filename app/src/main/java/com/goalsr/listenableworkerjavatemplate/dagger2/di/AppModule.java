package com.goalsr.listenableworkerjavatemplate.dagger2.di;


import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    static String saySomething(){
        return "We are ready";
    }

    @Provides
    static boolean getApp(Application application){
        return application==null;
    }

    /*@Provides
    static boolean getStatus(){
        return true;
    }*/
}
