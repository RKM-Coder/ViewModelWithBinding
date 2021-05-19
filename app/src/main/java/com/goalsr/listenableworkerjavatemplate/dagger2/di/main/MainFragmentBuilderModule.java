package com.goalsr.listenableworkerjavatemplate.dagger2.di.main;

import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.post.PostFragment;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();
    @ContributesAndroidInjector
    abstract PostFragment contributePostFragment();
}
