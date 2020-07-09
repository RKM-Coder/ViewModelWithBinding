package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import com.goalsr.listenableworkerjavatemplate.dagger2.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}
