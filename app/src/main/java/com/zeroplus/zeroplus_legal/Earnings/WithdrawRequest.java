package com.zeroplus.zeroplus_legal.Earnings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;

public class WithdrawRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_request);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Withdraw Request");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WithdrawRequest.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

    }
}