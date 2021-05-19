package com.goalsr.listenableworkerjavatemplate.dagger2.di.main;

import com.goalsr.listenableworkerjavatemplate.dagger2.network.main.MainApi;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.post.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {
    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

    @Provides
    static PostsRecyclerAdapter provideRecycleAdapter(){
        return new PostsRecyclerAdapter();
    }
}

