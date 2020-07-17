package com.goalsr.listenableworkerjavatemplate.dagger2.network.auth;

import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    /*@GET
    Call<ResponseBody> getDummyStuff();*/
    @GET("users/{id}")
    Flowable<UserResponse> getUser(
            @Path("id") int id
    );
}
