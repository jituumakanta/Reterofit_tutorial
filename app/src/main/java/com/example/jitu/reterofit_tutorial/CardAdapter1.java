package com.example.jitu.reterofit_tutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;


import java.util.List;

/**
 * Created by jitu on 12/9/2016.
 */

public class CardAdapter1 extends RecyclerView.Adapter<CardAdapter1.ViewHolder> {
    List<news> news;
    public Context context;

    public CardAdapter1(List<news> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            Glide.with(context).load(news.get(position).getImagelink()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);
            Log.d("image link",news.get(position).getImagelink());
            holder.textViewName.setText(news.get(position).getTitle());
            holder.textViewName1.setText(news.get(position).getTime());
            holder.textViewName2.setText(news.get(position).getSourcename());
        } catch (Exception e) {
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewName1;
        public TextView textViewName2;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.rating_image);
            textViewName = (TextView) itemView.findViewById(R.id.title);
            textViewName1 = (TextView) itemView.findViewById(R.id.subtitle);
            textViewName2 = (TextView) itemView.findViewById(R.id.description);

        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
