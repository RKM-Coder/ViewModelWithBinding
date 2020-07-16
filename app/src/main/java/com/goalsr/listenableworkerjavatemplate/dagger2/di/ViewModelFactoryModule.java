package com.goalsr.listenableworkerjavatemplate.dagger2.di;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.goalsr.listenableworkerjavatemplate.dagger2.viewmodel.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);

    /*@Provides
    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory factory){
        return factory;
    }*/
}
