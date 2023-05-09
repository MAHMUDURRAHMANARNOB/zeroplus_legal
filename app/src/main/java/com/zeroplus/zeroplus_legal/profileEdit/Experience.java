package com.zeroplus.zeroplus_legal.profileEdit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.ProfileSettingsActivity;
import com.zeroplus.zeroplus_legal.R;

import org.w3c.dom.Text;

public class Experience extends AppCompatActivity {

    TextView jDateView,lDateView;
    LinearLayout LDate;
    CheckBox CurrentyWorkHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Experience Information");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Experience.this, ProfileSettingsActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        /*Joining Date*/
        jDateView = (TextView) findViewById(R.id.jdateView);

        jDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDatePicker(jDateView);
            }
        });
        /*Joining Date End*/

        /*Leaving Date*/
        lDateView = (TextView) findViewById(R.id.ldateView);
        LDate = (LinearLayout) findViewById(R.id.lldate);

        lDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDatePicker(lDateView);
            }
        });
        /*Leaving Date End*/

        CurrentyWorkHere = (CheckBox) findViewById(R.id.checkBoxCWH);

        CurrentyWorkHere.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(CurrentyWorkHere.isChecked()){
                    LDate.setVisibility(View.GONE);
                }
                else{
                    LDate.setVisibility(View.VISIBLE);
                }
            }
        });



    }

    private void OpenDatePicker(TextView Where_To_Set){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String PickedDate = String.valueOf(day)+"-"+(month+1)+"-"+(year);
                Log.d("PickedDate",PickedDate);
                Where_To_Set.setText(PickedDate);
            }
        }, 2023, 0, 15);

        dialog.show();
    }
}