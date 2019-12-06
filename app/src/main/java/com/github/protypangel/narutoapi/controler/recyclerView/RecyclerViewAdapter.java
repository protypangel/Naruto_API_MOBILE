package com.github.protypangel.narutoapi.controler.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import com.github.protypangel.narutoapi.R;

public abstract class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private OnItemClickListener listener;
    private int count;
    protected RecyclerViewAdapter(int count){
        this.count = count;
    }
    public interface OnItemClickListener{
        void click(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_character,parent,false);
        return new MyViewHolder(view);
    }
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(url(position));
    }
    public int getItemCount() {
        return this.count;
    }
    public abstract String url(int position);
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.logoApplication);
            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    int position = getAdapterPosition();
                    listener.click(position);
                }
            });
        }
        private void display(String url){
            Picasso.with(this.imageView.getContext()).load(url).resize(128,128).into(this.imageView);
        }
    }
}
/*
*/