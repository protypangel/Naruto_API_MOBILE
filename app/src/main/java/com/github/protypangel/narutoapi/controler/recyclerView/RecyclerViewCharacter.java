package com.github.protypangel.narutoapi.controler.recyclerView;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerViewCharacter {
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    public RecyclerViewCharacter(int count, Context context, RecyclerView recyclerView){
        this.recyclerView = recyclerView;
        this.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        this.adapter = new RecyclerViewAdapter(count) {
            public String url(int position) {
                return getUrl(position);
            }
        };
        this.adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            public void click(int position) {
                clickListener(position);
            }
        });
        this.recyclerView.setAdapter(this.adapter);
    }
    public abstract void clickListener(int position);
    public abstract String getUrl(int position);
}