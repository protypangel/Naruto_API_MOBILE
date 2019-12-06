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
    private int size;
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

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = parent.getWidth() / 3;
        layoutParams.height = parent.getWidth() / 3;
        this.size = parent.getWidth() / 3;
        view.setLayoutParams(layoutParams);

        return new MyViewHolder(view);
    }
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(url(position),size);
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
        private void display(String url,int size){
            Picasso.with(this.imageView.getContext()).load(url).resize(size,size).into(this.imageView);
        }
    }
}
