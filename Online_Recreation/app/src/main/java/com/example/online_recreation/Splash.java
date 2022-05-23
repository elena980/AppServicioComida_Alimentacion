package com.example.online_recreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity implements Animation.AnimationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        Typeface myFont = Typeface.createFromAsset(getAssets(), "little.otf");
        TextView title = (TextView)findViewById(R.id.titlesplahs);
        title.setTypeface(myFont);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animation);
        title.startAnimation(anim);
        // anim.setAnimationListener(this);

        ImageView logo = (ImageView) findViewById(R.id.imageLogo);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.animation_logo);
        logo.startAnimation(animation1);
        animation1.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish(); // so that there is no return to the splash

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}