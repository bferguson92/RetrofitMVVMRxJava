package com.example.retrofitmvvmrxjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvmrxjava.R;
import com.example.retrofitmvvmrxjava.model.PostResponse;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<PostResponse> posts;


    public  PostAdapter(List<PostResponse> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        String userIdText = Integer.toString(posts.get(position).getUserId());
        String idText = Integer.toString(posts.get(position).getId());

        holder.userId.setText(userIdText);
        holder.id.setText(idText);
        holder.body.setText(posts.get(position).getBody());
        holder.title.setText(posts.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView id;
        TextView body;
        TextView title;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userid_display);
            id = itemView.findViewById(R.id.id_display);
            body = itemView.findViewById(R.id.body_display);
            title = itemView.findViewById(R.id.title_display);
        }
    }
}
