package com.goalsr.listenableworkerjavatemplate.dagger2.di.main;

import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.di.ViewModelKey;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.post.PostViewModel;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel authViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindPostViewModel(PostViewModel postViewModel);
}
