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
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_personalCases;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_personalCases;

import java.util.ArrayList;
import java.util.List;

public class personalCases extends AppCompatActivity {

    private RecyclerView PersonalCaseRV;
    private RecyclerView.Adapter adapter;
    private List<list_personalCases> personal_cases_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_cases);
        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Personal Cases");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(personalCases.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        PersonalCaseRV = (RecyclerView) findViewById(R.id.RVPersonal_CASES);
        PersonalCaseRV.setHasFixedSize(true);
        PersonalCaseRV.setLayoutManager(new LinearLayoutManager(this));

        personal_cases_list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list_personalCases personalCases = new list_personalCases(
                    "আউজপাড়া মৌজা সাভার","সাভার-০১-২০২৩","সাভার-০১-২০২৩",
                    "29/03/2023","Open","Open","Plaintiff"
            );
            personal_cases_list.add(personalCases);
        }
        adapter = new adapter_personalCases(personal_cases_list,this);
        PersonalCaseRV.setAdapter(adapter);
    }
}