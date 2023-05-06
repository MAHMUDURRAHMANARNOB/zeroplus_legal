package com.zeroplus.zeroplus_legal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AccountSettingsActivity extends AppCompatActivity {

    LinearLayout LLPS,CP,HiddenProcessCP,HiddenProcessExpandCP;
    ImageButton ExpandBtnCP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Account Settings");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountSettingsActivity.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*toolbar Finish*/

        /*Change Password*/
        CP = (LinearLayout) findViewById(R.id.cp);
        ExpandBtnCP = (ImageButton) findViewById(R.id.cpIMB);
        HiddenProcessCP = (LinearLayout) findViewById(R.id.changePassHidden);
        HiddenProcessExpandCP = (LinearLayout) findViewById(R.id.changePassShow);
        HiddenProcessCP.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        CP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { expand(HiddenProcessCP); }
        });
        ExpandBtnCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(HiddenProcessCP);
            }
        });



        /*Pyment Settings Functionality start*/
        LLPS = findViewById(R.id.LLPS);
        LLPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountSettingsActivity.this, PaymentSettings.class);
                startActivity(i);
            }
        });
        /*Pyment Settings Functionality end*/

    }

    private void expand(LinearLayout Process) {
        int v = (Process.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(Process, new AutoTransition());
        Process.setVisibility(v);
    }
}