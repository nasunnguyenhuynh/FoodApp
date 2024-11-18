package com.example.demofoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofoodapp.R;
import com.example.demofoodapp.models.FeatureModel;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {
    List<FeatureModel> list;

    public FeaturedAdapter(List<FeatureModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FeaturedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeaturedAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.featured_img);
            name = itemView.findViewById(R.id.featured_name);
            desc = itemView.findViewById(R.id.featured_des);
        }
    }
}
