package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import android.app.Application;

import com.goalsr.listenableworkerjavatemplate.dagger2.DaggerBaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        modules = {AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class
        }
)
public interface AppComponent extends AndroidInjector<DaggerBaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
