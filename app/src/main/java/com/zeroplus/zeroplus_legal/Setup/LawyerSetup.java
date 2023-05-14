package com.zeroplus.zeroplus_legal.Setup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.panelLawyers;

public class LawyerSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_setup);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Lawyer Setup");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LawyerSetup.this, panelLawyers.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/
    }
}