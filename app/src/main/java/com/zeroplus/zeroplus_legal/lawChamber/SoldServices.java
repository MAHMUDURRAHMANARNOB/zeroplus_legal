package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.ProfileSettingsActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_SoldServices;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_SoldServices;
import com.zeroplus.zeroplus_legal.profileEdit.BasicInfo;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SoldServices extends AppCompatActivity {

    private TableLayout SoldServiceTable;

    private RecyclerView SoldServicesRV;
    private RecyclerView.Adapter adapter;
    private List<list_SoldServices> soldServices_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_services);

        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Sold Services");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoldServices.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        SoldServicesRV = (RecyclerView) findViewById(R.id.RVSold_Services);
        SoldServicesRV.setHasFixedSize(true);
        SoldServicesRV.setLayoutManager(new LinearLayoutManager(this));

        soldServices_list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list_SoldServices earnings = new list_SoldServices(
                    "Family Law", "Digital Study Room",
                    "Basic", "5.00", "4.00", "14/12/2022", "Done");

            soldServices_list.add(earnings);
        }
        adapter = new adapter_SoldServices(soldServices_list, this);
        SoldServicesRV.setAdapter(adapter);

    }
}