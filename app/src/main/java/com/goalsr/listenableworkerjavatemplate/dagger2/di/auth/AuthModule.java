package com.goalsr.listenableworkerjavatemplate.dagger2.di.auth;

import com.goalsr.listenableworkerjavatemplate.dagger2.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {
    @Provides
    static AuthApi ProvideAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

}
