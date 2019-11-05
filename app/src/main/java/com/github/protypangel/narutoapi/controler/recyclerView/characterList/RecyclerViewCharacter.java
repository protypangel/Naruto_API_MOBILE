package com.github.protypangel.narutoapi.controler.recyclerView.characterList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerViewCharacter {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    public RecyclerViewCharacter(){
        this.recyclerView = getRecyclerView();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.i("TESTE","here");
        this.adapter = new RecyclerViewAdapter() {
            public String name(int position) {
                return getName(position);
            }
            public String url(int position) {
                return getUrl(position);
            }
            public int count() {
                return getCount();
            }
        };
        this.adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            public void click(int position) {
                onClick(position);
            }
        });
        this.recyclerView.setAdapter(this.adapter);
    }
    public abstract int getCount();
    public abstract String getName(int position);
    public abstract String getUrl(int position);
    public abstract Context getContext();
    public abstract RecyclerView getRecyclerView();
    public abstract void onClick(int position);
}