package com.example.retrofitmvvmrxjava.view;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitmvvmrxjava.R;
import com.example.retrofitmvvmrxjava.adapter.PostAdapter;
import com.example.retrofitmvvmrxjava.model.PostResponse;
import com.example.retrofitmvvmrxjava.viewmodel.MainViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
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

        disposable = mainViewModel.getPosts().subscribe(posts ->{
                recyclerView.setAdapter(new PostAdapter(posts));
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                }, error -> Log.e("ERROR", "nothing"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
