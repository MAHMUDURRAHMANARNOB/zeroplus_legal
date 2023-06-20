package com.zeroplus.zeroplus_legal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Packages extends AppCompatActivity {

    ImageView Super, Star, Specialist, General;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);

        Super = (ImageView) findViewById(R.id.imgSuperLawyer);
        Glide.with(this)
                .load(R.drawable.lawyer_a)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(Super);

        Star = (ImageView) findViewById(R.id.imgStarLawyer);
        Glide.with(this)
                .load(R.drawable.lawyer_b)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(Star);

        Specialist = (ImageView) findViewById(R.id.imgSpecialistLawyer);
        Glide.with(this)
                .load(R.drawable.lawyer_c)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(Specialist);

        General = (ImageView) findViewById(R.id.imgGeneralLawyer);
        Glide.with(this)
                .load(R.drawable.lawyer_d)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(General);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Packages");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Packages.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);



    }
}