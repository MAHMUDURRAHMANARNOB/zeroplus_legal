package com.zeroplus.zeroplus_legal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileSettingsActivity extends AppCompatActivity {

    LinearLayout BasicInfo,ProfInfo, ExpInfo, EduInfo, PortInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Profile Settings");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileSettingsActivity.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);

        BasicInfo = findViewById(R.id.LLBI);
        ProfInfo = findViewById(R.id.LLProfInfo);
        ExpInfo = findViewById(R.id.LLExpInfo);
        EduInfo = findViewById(R.id.LLEduInfo);
        PortInfo = findViewById(R.id.LLPortInfo);

        BasicInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(ProfileSettingsActivity.this, com.zeroplus.zeroplus_legal.profileEdit.BasicInfo.class);
                startActivity(Int);
            }
        });
        ProfInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(ProfileSettingsActivity.this, com.zeroplus.zeroplus_legal.profileEdit.Professional.class);
                startActivity(Int);
            }
        });
        ExpInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(ProfileSettingsActivity.this, com.zeroplus.zeroplus_legal.profileEdit.Experience.class);
                startActivity(Int);
            }
        });
        EduInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(ProfileSettingsActivity.this, com.zeroplus.zeroplus_legal.profileEdit.Educational.class);
                startActivity(Int);
            }
        });
        PortInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(ProfileSettingsActivity.this, com.zeroplus.zeroplus_legal.profileEdit.Portfolio.class);
                startActivity(Int);
            }
        });

    }
}