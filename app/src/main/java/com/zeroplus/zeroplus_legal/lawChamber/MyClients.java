package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.Setup.ClientSetup;

public class MyClients extends AppCompatActivity {

    private TableLayout MyClientsTable;
    Button btnClientSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clients);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("My Clients");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyClients.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        MyClientsTable=(TableLayout)findViewById(R.id.tableMyClients);
        TableLayout();

        btnClientSetup = (Button) findViewById(R.id.btnClientSetup);
        btnClientSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myServiceInt = new Intent(MyClients.this, com.zeroplus.zeroplus_legal.Setup.ClientSetup.class);
                startActivity(myServiceInt);
            }
        });
    }

    public void TableLayout(){

        MyClientsTable.removeAllViewsInLayout();
        int flag=1;

        for (int i=-1; i<10; i++) {

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            if (flag == 1) {

                TextView Name = new TextView(this);
                tableHeaderDesign(Name, " Name ");
                tr.addView(Name);

                TextView Phone = new TextView(this);
                tableHeaderDesign(Phone, " Phone ");
                tr.addView(Phone);

                TextView Email = new TextView(this);
                tableHeaderDesign(Email, " Email ");
                tr.addView(Email);

                MyClientsTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                MyClientsTable.addView(vline); // add line below heading
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
                tableRowDesign(phone, " phone ");
                tr.addView(phone);

                TextView email = new TextView(this);
                tableRowDesign(email, " email ");
                tr.addView(email);

                MyClientsTable.addView(tr);

                
                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                MyClientsTable.addView(vline1);  // add line below each row
            }
        }


    }

    private void tableHeaderDesign(TextView a, String Text){

        a.setText(Text);
        a.setTypeface(null, Typeface.BOLD);
        a.setTextColor(Color.WHITE);
        a.setBackgroundResource(R.drawable.tableheader);
        a.setTextSize(20);
    }

    private void tableRowDesign(TextView b, String RowText){

        b.setText(RowText);
        b.setBackgroundResource(R.drawable.table_row);
        b.setTextColor(Color.BLACK);
        b.setTextSize(17);
    }
}