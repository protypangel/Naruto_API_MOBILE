package com.github.protypangel.narutoapi.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonStorage {
    private static API api = null;

    public static API getApiInstance(){
        if(api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Link.api)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(API.class);
        }
        return api;
    }
}
