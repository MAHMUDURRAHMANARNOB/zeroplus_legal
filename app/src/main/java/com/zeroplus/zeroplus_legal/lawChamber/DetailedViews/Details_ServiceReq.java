package com.zeroplus.zeroplus_legal.lawChamber.DetailedViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.ServiceRequest;
import com.zeroplus.zeroplus_legal.lawChamber.zpCases;

public class Details_ServiceReq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_service_req);

        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Requested Services");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Details_ServiceReq.this, ServiceRequest.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/
        Bitmap clientImage = BitmapFactory.decodeResource(getResources(), R.drawable.man);
        TextView txtclientName = (TextView) findViewById(R.id.txtclientName);
        TextView txtServiceName = (TextView) findViewById(R.id.txtServiceName);
        TextView txtStartingDate = (TextView) findViewById(R.id.txtStartingDate);
        TextView _serviceType = (TextView) findViewById(R.id._serviceType);
        TextView txtServicePrice = (TextView) findViewById(R.id.txtServicePrice);
        TextView _serviceCategory = (TextView) findViewById(R.id._serviceCategory);
        ImageView clientImg = (ImageView) findViewById(R.id.clientImg);

        txtclientName.setText(getIntent().getStringExtra("ClientName"));
        txtServiceName.setText(getIntent().getStringExtra("ServiceName"));
        txtStartingDate.setText(getIntent().getStringExtra("StartingDate"));
        _serviceType.setText(getIntent().getStringExtra("ServiceType"));
        txtServicePrice.setText(getIntent().getStringExtra("ServicePrice"));
        _serviceCategory.setText(getIntent().getStringExtra("ServiceCategory"));
        clientImg.setImageBitmap(clientImage);
    }
}