package com.zeroplus.zeroplus_legal.lawChamber.DetailedViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.SoldServices;
import com.zeroplus.zeroplus_legal.lawChamber.personalCases;

public class Details_PersonalCase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_personal_case);

        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Case Details");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Details_PersonalCase.this, personalCases.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        TextView txtfileName = (TextView) findViewById(R.id.txtfileName);
        TextView txtfileno = (TextView) findViewById(R.id.txtfileno);
        TextView txtcaseNo = (TextView) findViewById(R.id.txtcaseNo);
        TextView _caseStatus = (TextView) findViewById(R.id._caseStatus);
        TextView _judgementStatus = (TextView) findViewById(R.id._judgementStatus);
        TextView _hearingDate = (TextView) findViewById(R.id._hearingDate);
        TextView _judgementDate = (TextView) findViewById(R.id._judgementDate);
        TextView _clientType = (TextView) findViewById(R.id._clientType);

        txtfileName.setText(getIntent().getStringExtra("FileName"));
        txtfileno.setText(getIntent().getStringExtra("FileNo"));
        txtcaseNo.setText(getIntent().getStringExtra("CaseNo"));
        _caseStatus.setText(getIntent().getStringExtra("CaseStatus"));
        _judgementStatus.setText(getIntent().getStringExtra("Judgement"));
        _clientType.setText(getIntent().getStringExtra("ClientType"));
        /*_judgementDate.setText(getIntent().getStringExtra("FileName"));
        _clientType.setText(getIntent().getStringExtra("FileName"));*/
    }
}