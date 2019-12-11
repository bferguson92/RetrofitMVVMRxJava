package com.example.retrofitmvvmrxjava.network;

import com.example.retrofitmvvmrxjava.model.PostResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFactory {
    private PostService postService;

    public PostFactory(){
        postService = createService(createRetrofitInstance());
    }

    private Retrofit createRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private PostService createService(Retrofit retrofit){
        return retrofit.create(PostService.class);
    }

    public Observable<List<PostResponse>> getPosts(){
        return postService.getPosts();
    }
}
