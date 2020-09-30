package com.proyecto.mychurch.Adapters;

import android.view.View;
import android.view.ViewGroup;

import com.proyecto.mychurch.Models.ModelFeed;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_news extends RecyclerView.Adapter<Adapter_news.post_viewHolder> {

    ArrayList<ModelFeed> modelnewsArraylist = new ArrayList<>();


    @NonNull
    @Override
    public post_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull post_viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelnewsArraylist.size();
    }

    public class post_viewHolder extends RecyclerView.ViewHolder{

        public post_viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
