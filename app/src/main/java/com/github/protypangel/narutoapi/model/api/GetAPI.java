package com.github.protypangel.narutoapi.model.api;

import android.util.Log;

import com.github.protypangel.narutoapi.model.personnage.Personnage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class GetAPI {
    protected GetAPI(){
        this.get();
    }
    private void get(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Link.api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        Call<List<Personnage>> call = api.get();
        call.enqueue(new Callback<List<Personnage>>() {
            @Override
            public void onResponse(Call<List<Personnage>> call, Response<List<Personnage>> response) {
                if(!response.isSuccessful()){
                    Log.i("GET API","CODE:["+response.code()+"] "+response.errorBody());
                    return;
                }
                successful(response.body());
            }
            @Override
            public void onFailure(Call<List<Personnage>> call, Throwable t) {
                Log.i("GET API","onFailure:"+t.getMessage());
            }
        });
    }
    public abstract void successful(List<Personnage> personnages);
}
