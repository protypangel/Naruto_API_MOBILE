package com.github.protypangel.narutoapi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.protypangel.narutoapi.R;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class StartActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private GifDrawable gifDrawable;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        this.gifImageView = findViewById(R.id.activity_start_IdOfThisGif);
        this.gifDrawable = (GifDrawable) this.gifImageView.getDrawable();
    }
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                animation();
            }
        }).start();
    }

    private void animation() {
        this.gifDrawable.reset();
        while(this.gifDrawable.getCurrentFrameIndex() != this.gifDrawable.getNumberOfFrames()-1){}
        this.gifDrawable.stop();
        startActivity(new Intent(this, MainActivity.class));
    }
}
