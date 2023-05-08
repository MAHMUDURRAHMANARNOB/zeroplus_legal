package com.zeroplus.zeroplus_legal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.paymentInventory.data_PM;

public class PaymentSettings extends AppCompatActivity {

    Spinner spinner_pm;
    LinearLayout HiddenProcessBI,HiddenProcessExpandBI,HiddenProcessAP, HiddenProcessExpandAP,HiddenProcessMB,HiddenProcessExpandMB;
    LinearLayout BIU,APM,AMB;
    ImageButton ExpandBtnBI, ExpandBtnAP, ExpandBtnMB, CloseBtnBI, CloseBtnAP, CloseBtnMB;
    private PaymentMethodAdapter pmadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_settings);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Payment Settings");
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentSettings.this, AccountSettingsActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        /*Basic Info*/
        BIU = (LinearLayout) findViewById(R.id.biu);
        ExpandBtnBI = (ImageButton) findViewById(R.id.biIMB);
        CloseBtnBI = (ImageButton) findViewById(R.id.bicIMB);
        HiddenProcessBI = (LinearLayout) findViewById(R.id.bankInfoHidden);
        HiddenProcessExpandBI = (LinearLayout) findViewById(R.id.bankInfoShow);
        HiddenProcessBI.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        BIU.setOnClickListener(view -> expand(HiddenProcessBI,ExpandBtnBI,CloseBtnBI));
        ExpandBtnBI.setOnClickListener(view -> expand(HiddenProcessBI,ExpandBtnBI,CloseBtnBI));
        CloseBtnBI.setOnClickListener(view -> expand(HiddenProcessBI,ExpandBtnBI,CloseBtnBI));


        /*Payment Method*/
        APM = (LinearLayout) findViewById(R.id.apm);
        ExpandBtnAP = (ImageButton) findViewById(R.id.apIMB);
        CloseBtnAP = (ImageButton) findViewById(R.id.apcIMB);
        HiddenProcessAP = (LinearLayout) findViewById(R.id.addpaymentHidden);
        HiddenProcessExpandAP = (LinearLayout) findViewById(R.id.addpaymentShow);
        HiddenProcessAP.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        APM.setOnClickListener(view->
                expand(HiddenProcessAP,ExpandBtnAP,CloseBtnAP));
        ExpandBtnAP.setOnClickListener(view ->
                expand(HiddenProcessAP,ExpandBtnAP,CloseBtnAP));
        CloseBtnAP.setOnClickListener(view ->
                expand(HiddenProcessAP,ExpandBtnAP,CloseBtnAP));

        /*Mobile Banking*/
        AMB = (LinearLayout) findViewById(R.id.amb);
        ExpandBtnMB = (ImageButton) findViewById(R.id.mbIMB);
        CloseBtnMB = (ImageButton) findViewById(R.id.mbcIMB);
        HiddenProcessMB = (LinearLayout) findViewById(R.id.mobileBankingHidden);
        HiddenProcessExpandMB = (LinearLayout) findViewById(R.id.mobileBankingShow);
        HiddenProcessMB.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        AMB.setOnClickListener(view ->
                expand(HiddenProcessMB,ExpandBtnMB,CloseBtnMB));
        ExpandBtnMB.setOnClickListener(view ->
                expand(HiddenProcessMB,ExpandBtnMB,CloseBtnMB));
        CloseBtnMB.setOnClickListener(view ->
                expand(HiddenProcessMB,ExpandBtnMB,CloseBtnMB));


        /*Payment Method Spinner*/
        spinner_pm = findViewById(R.id.PaymentSelector);
        pmadapter = new PaymentMethodAdapter(PaymentSettings.this, data_PM.getPM());
        spinner_pm.setAdapter(pmadapter);

        /*Payment Method Spinner End*/


    }

    /*private void expand(LinearLayout Process) {
        int v = (Process.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(Process, new AutoTransition());
        Process.setVisibility(v);
    }*/
    private void expand(LinearLayout Process, ImageButton openButton,ImageButton closeButton) {
        int v = ( Process.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        // Set the visibility of the open and close buttons based on the visibility of the Process layout
        if (v == View.VISIBLE) {
            openButton.setVisibility(View.GONE);
            closeButton.setVisibility(View.VISIBLE);
        } else {
            openButton.setVisibility(View.VISIBLE);
            closeButton.setVisibility(View.GONE);
        }
        TransitionManager.beginDelayedTransition(Process, new AutoTransition());
        Process.setVisibility(v);
    }
}