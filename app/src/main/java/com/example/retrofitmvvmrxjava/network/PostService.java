package com.example.retrofitmvvmrxjava.network;

import com.example.retrofitmvvmrxjava.model.PostResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostService {
    @GET("posts")
    Observable<List<PostResponse>> getPosts();
}
