package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;

public class panelLawyers extends AppCompatActivity {

    private TableLayout LawyerTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_lawyers);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Lawyers");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(panelLawyers.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        Button btnlawyer_setup = (Button) findViewById(R.id.btnlawyer_setup);
        btnlawyer_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myServiceInt = new Intent(panelLawyers.this, com.zeroplus.zeroplus_legal.Setup.LawyerSetup.class);
                startActivity(myServiceInt);
            }
        });

        LawyerTable=(TableLayout)findViewById(R.id.tableLawyers);
        TableLayout();
    }


    public void TableLayout(){

        LawyerTable.removeAllViewsInLayout();
        int flag=1;

        for (int i=-1; i<10; i++) {

            TableRow tr = new TableRow(this);
            TableLayout.LayoutParams lp =
                    new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT);
            tr.setLayoutParams(lp);
            lp.setMargins(10,10,10,10);

            if (flag == 1) {

                TextView Name = new TextView(this);
                tableHeaderDesign(Name, " Name ");
                tr.addView(Name);

                TextView Phone = new TextView(this);
                tableHeaderDesign(Phone, " Email ");
                tr.addView(Phone);

                TextView Email = new TextView(this);
                tableHeaderDesign(Email, " Mobile No ");
                tr.addView(Email);

                TextView Details = new TextView(this);
                tableHeaderDesign(Details, " Details ");
                tr.addView(Details);

                LawyerTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLACK);
                LawyerTable.addView(vline); // add line below heading
                flag = 0;
            } else {
            /*JSONObject object =jsonArray.getJSONObject(i);
            String id = object.getString("id");
            String cyclone_name = object.getString("cyclone_name");
            String member_name =  object.getString("member_name");
            String org_name = object.getString("org_name");
            String pay_amout = object.getString("pay_amout");
            String pay_gen_date = object.getString("pay_gen_date");
            String pay_date = object.getString("pay_date");*/

                TextView name = new TextView(this);
                tableRowDesign(name, " name ");
                tr.addView(name);

                TextView phone = new TextView(this);
                tableRowDesign(phone, " email ");
                tr.addView(phone);

                TextView email = new TextView(this);
                tableRowDesign(email, " phone ");
                tr.addView(email);

                TextView details = new TextView(this);
                tableRowDesign(details, " detailssssssssssssss ");
                tr.addView(details);

                LawyerTable.addView(tr);


                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                LawyerTable.addView(vline1);  // add line below each row

                View v = new View(this);
                v.setLayoutParams(new TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT));
                v.setBackgroundColor(Color.BLACK);
            }
        }


    }

    private void tableHeaderDesign(TextView a, String Text){

        a.setText(Text);
        a.setTypeface(null, Typeface.BOLD);
        a.setTextColor(Color.WHITE);
        a.setBackgroundResource(R.drawable.tableheader);
        a.setPadding(5,2,5,2);
        a.setGravity(Gravity.CENTER);
        a.setTextSize(20);
    }

    private void tableRowDesign(TextView b, String RowText){

        b.setText(RowText);
        b.setBackgroundResource(R.drawable.table_row);
        b.setTextColor(Color.BLACK);
        b.setPadding(5,0,1,2);
        b.setGravity(Gravity.CENTER);
        b.setTextSize(17);
    }


}