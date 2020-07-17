package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import android.app.Application;

import com.goalsr.listenableworkerjavatemplate.dagger2.DaggerBaseApplication;
import com.goalsr.listenableworkerjavatemplate.dagger2.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,ViewModelFactoryModule.class
        }
)
public interface AppComponent extends AndroidInjector<DaggerBaseApplication> {

    SessionManager sessionManager();
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
