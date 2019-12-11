package com.example.retrofitmvvmrxjava.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvmrxjava.R;
import com.example.retrofitmvvmrxjava.adapter.PostAdapter;
import com.example.retrofitmvvmrxjava.viewmodel.MainViewModel;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.display_posts);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        disposable = mainViewModel.getPosts().subscribeOn(Schedulers.io())
                .subscribe(posts ->{
                recyclerView.setAdapter(new PostAdapter(posts));
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                }, error -> Log.e("ERROR", error.toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
