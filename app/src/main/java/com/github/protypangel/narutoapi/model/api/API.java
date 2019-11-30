package com.github.protypangel.narutoapi.model.api;

import com.github.protypangel.narutoapi.model.personnage.Personnage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("index.php")
    Call<List<Personnage>> get();
}
