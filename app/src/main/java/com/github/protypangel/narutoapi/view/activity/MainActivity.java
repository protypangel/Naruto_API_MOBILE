package com.github.protypangel.narutoapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.controler.activity.MainController;
import com.github.protypangel.narutoapi.model.api.Link;
import com.github.protypangel.narutoapi.model.personnage.Personnage;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private MainController mainController;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set the logo
        logoInitialize();
        // Create the main Controller
        mainController = new MainController(this);
    }
    private void logoInitialize(){
        ImageView imageView = findViewById(R.id.logoApplication);
        Picasso.with(imageView.getContext()).load(Link.logo).resize(64,64).into(imageView);
    }
    public void otherActivity(Personnage personnage){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Character",personnage);
        startActivity(intent);
    }
}