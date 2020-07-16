package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import com.goalsr.listenableworkerjavatemplate.dagger2.di.auth.AuthViewModelsModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthActivity;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
    modules = {AuthViewModelsModule.class}
            )
    abstract AuthActivity contributeAuthActivity();

}
