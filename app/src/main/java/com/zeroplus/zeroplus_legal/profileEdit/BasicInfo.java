package com.zeroplus.zeroplus_legal.profileEdit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.Packages;
import com.zeroplus.zeroplus_legal.ProfileSettingsActivity;
import com.zeroplus.zeroplus_legal.R;

public class BasicInfo extends AppCompatActivity {

    LinearLayout GI,HiddenProcessGI,HiddenProcessExpandGI,AddressLL,HiddenProcessAD,HiddenProcessExpandAD;
    ImageButton ExpandBtnGI,ExpandBtnAD,CloseBtnGI,CloseBtnAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Basic Information");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BasicInfo.this, ProfileSettingsActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        /* General Info Panel Popup start*/

        GI = (LinearLayout) findViewById(R.id.giu);
        ExpandBtnGI = (ImageButton) findViewById(R.id.giIMB);
        CloseBtnGI = (ImageButton) findViewById(R.id.gicIMB);
        HiddenProcessGI = (LinearLayout) findViewById(R.id.genInfoHidden);
        HiddenProcessExpandGI = (LinearLayout) findViewById(R.id.genInfoShow);
        HiddenProcessGI.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        /*GI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(HiddenProcessGI,ExpandBtnGI,CloseBtnGI);

            }
        });
        ExpandBtnGI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(HiddenProcessGI,ExpandBtnGI,CloseBtnGI);
            }
        });
        CloseBtnGI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand(HiddenProcessGI,ExpandBtnGI,CloseBtnGI);
            }
        });*/
        GI.setOnClickListener(view -> expand(HiddenProcessGI, ExpandBtnGI, CloseBtnGI));
        ExpandBtnGI.setOnClickListener(view -> expand(HiddenProcessGI, ExpandBtnGI, CloseBtnGI));
        CloseBtnGI.setOnClickListener(view -> expand(HiddenProcessGI, ExpandBtnGI, CloseBtnGI));


        /*General Info Panel popup end*/

        /* General Info Panel Popup start*/

        AddressLL = (LinearLayout) findViewById(R.id.address);
        ExpandBtnAD = (ImageButton) findViewById(R.id.addIMB);
        CloseBtnAD = (ImageButton) findViewById(R.id.addcIMB);
        HiddenProcessAD = (LinearLayout) findViewById(R.id.addressHidden);
        HiddenProcessExpandAD = (LinearLayout) findViewById(R.id.addressShow);
        HiddenProcessAD.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        AddressLL.setOnClickListener(view ->
                expand(HiddenProcessAD,ExpandBtnAD,CloseBtnAD));

        ExpandBtnAD.setOnClickListener(view ->
                expand(HiddenProcessAD,ExpandBtnAD,CloseBtnAD));

        CloseBtnAD.setOnClickListener(view ->
                expand(HiddenProcessAD,ExpandBtnAD,CloseBtnAD));

        /*General Info Panel popup end*/

    }

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