package com.example.newsclone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsclone.FragmentClass.ModelClass;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassesArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassesArrayList) {
        this.context = context;
        this.modelClassesArrayList = modelClassesArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Integer(context,webView.class);
                intent.putExtra("url",modelClassesArrayList.get(position).getUrl());
                context.startActivities(intent);
            }
        });
        holder.tTime.setText("Published At:"+modelClassesArrayList.get(position).getpublishedAt());
        holder.tAuthor.setText(modelClassesArrayList.get(position).getAuthor());
        holder.tHeading.setText(modelClassesArrayList.get(position).getTitle());
        holder.tContent.setText(modelClassesArrayList.get(position).getDescription());

        Glide.with(context).load(modelClassesArrayList.get(position).getUrlToImage());
        holder.tAuthor.setText(modelClassesArrayList.get(position).getAuthor());
        holder.tAuthor.setText(modelClassesArrayList.get(position).getAuthor());
    }



    @Override
    public int getItemCount() {
        return modelClassesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tHeading,tContent,tAuthor,tTime;
        CardView cardView;
        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tHeading=itemView.findViewById(R.id.heading);
            tContent=itemView.findViewById(R.id.content);
            tAuthor=itemView.findViewById(R.id.author);
            tTime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
        }

    }
}
