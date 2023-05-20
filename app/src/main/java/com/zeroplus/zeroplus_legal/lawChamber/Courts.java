package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.Earnings.Models.list_Earnings;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_courts;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_courts;

import java.util.ArrayList;
import java.util.List;

public class Courts extends AppCompatActivity {

    private RecyclerView courtsRV;
    private RecyclerView.Adapter adapter;
    private List<list_courts> courts_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courts);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Courts");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Courts.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/



        Button btnCourtSetup = (Button) findViewById(R.id.btnCourtSetup);
        btnCourtSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myServiceInt = new Intent(Courts.this, com.zeroplus.zeroplus_legal.Setup.CourtSetup.class);
                startActivity(myServiceInt);
            }
        });


        /*RecyclerView*/
        courtsRV = (RecyclerView) findViewById(R.id.RVCourts);
        courtsRV.setHasFixedSize(true);
        courtsRV.setLayoutManager(new LinearLayoutManager(this));

        courts_List = new ArrayList<>();

        for (int i = 0; i<10; i++){
            list_courts courts = new list_courts(
                    "Court 14","Court14@gmail.com","105","Dhaka","Bangladesh",
                    "New court to be setupCourse fee: Monthly Instalment 5000 taka (Total 6 instalments)"
            );

            courts_List.add(courts);
        }
        adapter = new adapter_courts(courts_List,this);
        courtsRV.setAdapter(adapter);
    }

}