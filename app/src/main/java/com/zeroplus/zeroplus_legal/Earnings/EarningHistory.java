package com.zeroplus.zeroplus_legal.Earnings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.Earnings.Models.list_Earnings;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Courts;

import java.util.ArrayList;
import java.util.List;

public class EarningHistory extends AppCompatActivity {
    private RecyclerView earnignsRV;
    private RecyclerView.Adapter adapter;
    private List<list_Earnings> earnings_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earning_history);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Earnings History");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EarningHistory.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        /*RecyclerView*/
        earnignsRV = (RecyclerView) findViewById(R.id.RVEarning_History);
        earnignsRV.setHasFixedSize(true);
        earnignsRV.setLayoutManager(new LinearLayoutManager(this));

        earnings_list = new ArrayList<>();

        for (int i = 0; i<10; i++){
            list_Earnings earnings = new list_Earnings(
                    "Bashundhara" + i+1, "10000","9500","23-12-23","100"
            );

            earnings_list.add(earnings);
        }
        adapter = new adapter_earnings(earnings_list,this);
        earnignsRV.setAdapter(adapter);


    }

    /*public void TableLayout(){

        EarningsTable.removeAllViewsInLayout();
        int flag=1;

        for (int i=-1; i<10; i++) {

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            if (flag == 1) {

                TextView Project_Name = new TextView(this);
                tableHeaderDesign(Project_Name, " Project Name ");
                tr.addView(Project_Name);

                TextView Paid_Amount = new TextView(this);
                tableHeaderDesign(Paid_Amount, " Paid Amount ");
                tr.addView(Paid_Amount);

                TextView Your_Earnings = new TextView(this);
                tableHeaderDesign(Your_Earnings, " Your Earnings ");
                tr.addView(Your_Earnings);

                TextView Paid_at = new TextView(this);
                tableHeaderDesign(Paid_at, " Paid at ");
                tr.addView(Paid_at);

                TextView Admin_Charge = new TextView(this);
                tableHeaderDesign(Admin_Charge, " Admin Charge ");
                tr.addView(Admin_Charge);

                EarningsTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                EarningsTable.addView(vline); // add line below heading
                flag = 0;
            } else {
            *//*JSONObject object =jsonArray.getJSONObject(i);
            String id = object.getString("id");
            String cyclone_name = object.getString("cyclone_name");
            String member_name =  object.getString("member_name");
            String org_name = object.getString("org_name");
            String pay_amout = object.getString("pay_amout");
            String pay_gen_date = object.getString("pay_gen_date");
            String pay_date = object.getString("pay_date");*//*

                TextView project_name = new TextView(this);
                tableRowDesign(project_name, " project name ");
                tr.addView(project_name);

                TextView paid_amount = new TextView(this);
                tableRowDesign(paid_amount, " paid_amount ");
                tr.addView(paid_amount);

                TextView your_earnings = new TextView(this);
                tableRowDesign(your_earnings, " your_earnings ");
                tr.addView(your_earnings);

                TextView paid_at = new TextView(this);
                tableRowDesign(paid_at, " paid_at ");
                tr.addView(paid_at);

                TextView admin_charge = new TextView(this);
                tableRowDesign(admin_charge, " admin_charge ");
                tr.addView(admin_charge);

                EarningsTable.addView(tr);


                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                EarningsTable.addView(vline1);  // add line below each row
            }
        }


    }*/

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