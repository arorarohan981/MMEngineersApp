package com.rohan.mmengineerco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  int SPLASH_SCREEN_TIME_IN_MILLIS =5000;
    //Animation variable
    private Animation topanim,bottomanim;
    //view variables
    private TextView tagline_text;
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//To Remove Notification bar i.e to display full screen

        topanim = AnimationUtils.loadAnimation(this,R.anim.topanimation);//Here we are loading the Animation
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottomanim);//Here we are loading the Animation
        logo =findViewById(R.id.logo);//Maps the view object with ID to ImageView Kind of Variable
        tagline_text=findViewById(R.id.tagline_logo_splashscreen);//Maps the view object with ID to TextView Kind of Variable
        logo.setAnimation(topanim);//to Apply Animation to a View Object
        tagline_text.setAnimation(bottomanim);//to Apply Animation to a View Object
        //new Handler is a Runnable object associated with a thread
        new Handler().postDelayed(new Runnable() {//postdelayed delays the process for a Specific amount of time
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,CategoryScreen.class);//intent is used to go from one activity to another
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_TIME_IN_MILLIS);

    }


}
