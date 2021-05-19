package com.goalsr.listenableworkerjavatemplate.dagger2.network.main;

import com.goalsr.listenableworkerjavatemplate.dagger2.model.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("posts")
    Flowable<List<Post>> getPostById(
            @Query("userId") int userid
    );
}
