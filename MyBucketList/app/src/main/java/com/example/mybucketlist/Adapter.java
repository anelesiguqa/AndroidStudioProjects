package com.example.mybucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ToDo[] toDos;

    public Adapter(ToDo[] todos) {
        this.toDos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(toDos[position]);
    }

    @Override
    public int getItemCount() {
        return toDos.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_view_description);
            image = itemView.findViewById(R.id.image_view_bucket_list_photo);
        }
        public void bind(ToDo todo) {
            name.setText(todo.name);
            image.setImageResource(todo.todoImage);
        }
    }
}
