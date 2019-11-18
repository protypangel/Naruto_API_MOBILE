package com.github.protypangel.narutoapi.controler.recyclerView;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.protypangel.narutoapi.view.recyclerView.characterList.RecyclerViewAdapter;

public abstract class RecyclerViewCharacter {
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    public RecyclerViewCharacter(int count, Context context, RecyclerView recyclerView){
        this.recyclerView = recyclerView;
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.adapter = new RecyclerViewAdapter(count) {
            public String name(int position) {
                return getName(position);
            }
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
    public abstract String getName(int position);
    public abstract String getUrl(int position);
}