package com.example.retrofitmvvmrxjava.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.retrofitmvvmrxjava.model.PostResponse;
import com.example.retrofitmvvmrxjava.network.PostFactory;

import java.util.List;

import io.reactivex.Observable;

public class MainViewModel extends AndroidViewModel {

    private PostFactory postFactory = new PostFactory();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public Observable<List<PostResponse>> getPosts(){
        return postFactory.getPosts();
    }
}
