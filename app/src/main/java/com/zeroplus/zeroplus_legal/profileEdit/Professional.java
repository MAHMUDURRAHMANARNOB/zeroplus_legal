package com.zeroplus.zeroplus_legal.profileEdit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.ProfileSettingsActivity;
import com.zeroplus.zeroplus_legal.R;

import java.lang.reflect.Array;

public class Professional extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    AutoCompleteTextView ACTV_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Professional Information");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Professional.this, ProfileSettingsActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

//        ACTV_gender = (AutoCompleteTextView) findViewById(R.id.ACTV_gender);
//
//        String[] gender = getResources().getStringArray(R.array.gender);
//        arrayAdapter = new ArrayAdapter<>(this,R.layout.gender_dropdown_item,gender);
//        ACTV_gender.setAdapter(arrayAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        ACTV_gender = (AutoCompleteTextView) findViewById(R.id.ACTV_gender);

        String[] gender = getResources().getStringArray(R.array.gender);
        arrayAdapter = new ArrayAdapter<>(this,R.layout.gender_dropdown_item,gender);
        ACTV_gender.setAdapter(arrayAdapter);

    }
}