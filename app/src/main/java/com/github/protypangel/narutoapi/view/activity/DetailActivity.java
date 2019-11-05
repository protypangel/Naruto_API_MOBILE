package com.github.protypangel.narutoapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.protypangel.narutoapi.R;
import com.github.protypangel.narutoapi.model.personnage.Personnage;
import com.github.protypangel.narutoapi.view.fragment.FragmentCapacite;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private FragmentCapacite capacite;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initialize();
        initializeFragment();
    }
    private void initialize() {
        Personnage personnage = getIntent().getParcelableExtra("Character");
        this.imageView = findViewById(R.id.detail_logo);
        this.textView = findViewById(R.id.detail_name);
        Picasso.with(imageView.getContext()).load("http://ns202518.ovh.net/mehdi/api/naruto/image/"+personnage.get().id+".jpg").resize(128,128).into(imageView);
        this.textView.setText(personnage.get().firstName + " " + personnage.get().lastName);
    }
    private void initializeFragment() {
        Personnage personnage = getIntent().getParcelableExtra("Character");
        this.capacite = new FragmentCapacite(personnage.get().puissance);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout_capacite,this.capacite)
                .commit();
    }
}
