package com.github.protypangel.narutoapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.controler.activity.MainController;
import com.github.protypangel.narutoapi.model.personnage.Personnage;

public class MainActivity extends AppCompatActivity {
    private MainController mainController;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the main Controller
        mainController = new MainController(this);
    }
    public void otherActivity(Personnage personnage){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Character",personnage);
        startActivity(intent);
    }
}