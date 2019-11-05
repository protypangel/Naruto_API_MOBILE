package com.github.protypangel.narutoapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.controler.recyclerView.characterList.RecyclerViewCharacter;
import com.github.protypangel.narutoapi.model.api.GetAPI;
import com.github.protypangel.narutoapi.model.personnage.Personnage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Personnage> personnages;
    private RecyclerViewCharacter recyclerViewCharacter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeLayout();
        getApi();
    }
    private void initializeLayout(){
        ImageView imageView = findViewById(R.id.logoApplication);
        Picasso.with(imageView.getContext()).load("http://ns202518.ovh.net/mehdi/api/naruto/image/logo.jpg").resize(64,64).into(imageView);
    }
    private void initialiazeRecyclerViewCharacter(){
        this.recyclerViewCharacter = new RecyclerViewCharacter() {
            public int getCount() {
                return personnages.size();
            }
            public String getName(int position) {
                return personnages.get(position).get().firstName + " " + personnages.get(position).get().lastName;
            }
            public String getUrl(int position) {
                return "http://ns202518.ovh.net/mehdi/api/naruto/image/"+personnages.get(position).get().id+".jpg";
            }
            public Context getContext() {
                return getApplicationContext();
            }
            public RecyclerView getRecyclerView() {
                RecyclerView recyclerView = findViewById(R.id.recyclerViewCharacter);
                return recyclerView;
            }
            public void onClick(int position) {
                otherActivity(position);
            }
        };
    }
    private void getApi(){
        new GetAPI() {
            @Override
            public void successful(List<Personnage> personnages) {
                getPersonnageFromApi(personnages);
            }
            @Override
            public void isntSuccessful(int code) {
                getIsntSuccessful(code);
            }
            @Override
            public void failed(String message) {
                getFailed(message);
            }
        };
    }
    private void getPersonnageFromApi(List<Personnage> personnages){
        this.personnages = personnages;
        initialiazeRecyclerViewCharacter();
    }
    private void getIsntSuccessful(int code){
        Toast.makeText(getApplicationContext(),"ERROR "+code,Toast.LENGTH_LONG);
    }
    private void getFailed(String message){
        Toast.makeText(getApplicationContext(),"ERROR: "+message,Toast.LENGTH_LONG);
    }
    private void otherActivity(int index){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Character",this.personnages.get(index));
        startActivity(intent);
    }
}