package com.iapps.animesearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    Timer timer;

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);

        //hooks
        image = findViewById(R.id.gambar);
        text1 = findViewById(R.id.txtmyself);
        text2 = findViewById(R.id.txtapplikasi);

        image.setAnimation(topAnim);
        text2.setAnimation(topAnim);
        text1.setAnimation(bottomAnim);


        //delay
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}