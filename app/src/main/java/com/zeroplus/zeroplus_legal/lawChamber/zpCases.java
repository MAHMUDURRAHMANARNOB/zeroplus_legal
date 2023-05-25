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
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_SoldServices;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_zpCases;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_SoldServices;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_zpCases;

import java.util.ArrayList;
import java.util.List;

public class zpCases extends AppCompatActivity {

    private RecyclerView ZPCASESRV;
    private RecyclerView.Adapter adapter;
    private List<list_zpCases> zpcases_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zp_cases);

        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Zeroplus Cases");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zpCases.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        ZPCASESRV = (RecyclerView) findViewById(R.id.RVZP_CASES);
        ZPCASESRV.setHasFixedSize(true);
        ZPCASESRV.setLayoutManager(new LinearLayoutManager(this));

        zpcases_list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list_zpCases zpcases = new list_zpCases(
                    "Mostafijur Rahman Jamalpur Land File", "mosta-01-2023",
                    "mosta-01-2023", "29/03/2023", "Judgement", "Close", "Plaintiff");

            zpcases_list.add(zpcases);
        }
        adapter = new adapter_zpCases(zpcases_list, this);
        ZPCASESRV.setAdapter(adapter);

    }
}