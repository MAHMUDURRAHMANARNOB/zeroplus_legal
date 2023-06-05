package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.RecyclerViewInterface;
import com.zeroplus.zeroplus_legal.lawChamber.DetailedViews.Details_PersonalCase;
import com.zeroplus.zeroplus_legal.lawChamber.DetailedViews.Details_ServiceReq;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_serviceRequest;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_ServiceRequests;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequest extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView ServiceRequestsRV;
    private RecyclerView.Adapter adapter;
    private List<list_ServiceRequests> serviceRequests_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request);
        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Service Requests");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ServiceRequest.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        ServiceRequestsRV = (RecyclerView) findViewById(R.id.RVService_Request);
        ServiceRequestsRV.setHasFixedSize(true);
        ServiceRequestsRV.setLayoutManager(new LinearLayoutManager(this));

        serviceRequests_list = new ArrayList<>();
        Bitmap clientImage = BitmapFactory.decodeResource(getResources(), R.drawable.man);

        for (int i = 0; i < 1; i++){
            list_ServiceRequests serviceRequests = new list_ServiceRequests(
                    "Sayduzzaman Shamim","Commercial Lobbing","5500",
                    "23/5/2023","Premium","Private",clientImage

            );
            list_ServiceRequests serviceRequests1 = new list_ServiceRequests(
                    "RI Tarofder","Eye/ophthalmology","5000",
                    "9/5/2023","Premium","Private",clientImage

            );
            serviceRequests_list.add(serviceRequests);
            serviceRequests_list.add(serviceRequests1);
        }
        adapter = new adapter_serviceRequest(this, serviceRequests_list,this);
        ServiceRequestsRV.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, Details_ServiceReq.class);

        intent.putExtra("ClientName",serviceRequests_list.get(position).getClientName());
        intent.putExtra("ServiceName",serviceRequests_list.get(position).getServiceName());
        intent.putExtra("StartingDate",serviceRequests_list.get(position).getStartingDate());
        intent.putExtra("ServiceType",serviceRequests_list.get(position).getCaseType());
        intent.putExtra("ServicePrice",serviceRequests_list.get(position).getServicePrice());
        intent.putExtra("ServiceCategory",serviceRequests_list.get(position).getPackageType());
        /*intent.putExtra("ClientImage",serviceRequests_list.get(position).getClientImage());*/
        startActivity(intent);
    }
}