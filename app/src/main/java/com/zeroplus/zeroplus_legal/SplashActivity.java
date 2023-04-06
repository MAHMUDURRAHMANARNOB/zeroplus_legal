package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        RunAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // This method will be executed once the timer is over
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);
    }

    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textanimation);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.txtZeroplus);
        TextView tv1 = (TextView) findViewById(R.id.txtWelcome);


        tv.clearAnimation();
        tv.startAnimation(a);
        tv1.clearAnimation();
        tv1.startAnimation(a);


    }

}