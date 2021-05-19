package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import com.goalsr.listenableworkerjavatemplate.dagger2.di.auth.AuthModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.di.auth.AuthViewModelsModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.di.main.MainFragmentBuilderModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.di.main.MainModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.di.main.MainProfileViewModelModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthActivity;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.MainDaggerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
    modules = {AuthViewModelsModule.class, AuthModule.class}
            )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {MainFragmentBuilderModule.class, MainProfileViewModelModule.class, MainModule.class}
    )
    abstract MainDaggerActivity contributeMainDraggeActivity();

}
