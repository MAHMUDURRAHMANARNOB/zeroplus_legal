package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.Earnings.EarningHistory;
import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.Earnings.Models.list_Earnings;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_appointments;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_appoinments;

import java.util.ArrayList;
import java.util.List;

public class Appointments extends AppCompatActivity {

    private RecyclerView appointmentsRV;
    private RecyclerView.Adapter adapter;
    private List<list_appoinments> appointments_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Appoinments");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Appointments.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        /*RecyclerView*/
        appointmentsRV = (RecyclerView) findViewById(R.id.RVAppoinments);
        appointmentsRV.setHasFixedSize(true);
        appointmentsRV.setLayoutManager(new LinearLayoutManager(this));

        appointments_List = new ArrayList<>();

        for (int i = 0; i<10; i++){
            list_appoinments earnings = new list_appoinments(
                    "Digital Study Room","1-1-1970","2-2-2023","Hearing Date 2022-12-17 added"
            );

            appointments_List.add(earnings);
        }
        adapter = new adapter_appointments(appointments_List,this);
        appointmentsRV.setAdapter(adapter);


    }
}