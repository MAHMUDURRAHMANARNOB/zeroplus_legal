package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.zeroplus.zeroplus_legal.ProfileSettingsActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.profileEdit.BasicInfo;

import org.json.JSONObject;

public class SoldServices extends AppCompatActivity {

    private TableLayout SoldServiceTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_services);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Sold Services");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SoldServices.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        SoldServiceTable=(TableLayout)findViewById(R.id.tableSoldService);
        TableLayout();
    }

    public void TableLayout(){

        SoldServiceTable.removeAllViewsInLayout();
        int flag=1;

        for (int i=-1; i<10; i++) {

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            if (flag == 1) {

                TextView Service_Title = new TextView(this);
                tableHeaderDesign(Service_Title, " Service Title ");
                tr.addView(Service_Title);

                TextView Client_Name = new TextView(this);
                tableHeaderDesign(Client_Name, " Client Name ");
                tr.addView(Client_Name);

                TextView Service_Type = new TextView(this);
                tableHeaderDesign(Service_Type, " Service Type ");
                tr.addView(Service_Type);

                TextView Amount = new TextView(this);
                tableHeaderDesign(Amount, " Amount ");
                tr.addView(Amount);

                TextView My_Earning = new TextView(this);
                tableHeaderDesign(My_Earning, " My Earning ");
                tr.addView(My_Earning);

                TextView Sold_Date = new TextView(this);
                tableHeaderDesign(Sold_Date, " Sold Date ");
                tr.addView(Sold_Date);

                TextView Status = new TextView(this);
                tableHeaderDesign(Status, " Status ");
                tr.addView(Status);


                SoldServiceTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                SoldServiceTable.addView(vline); // add line below heading
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

                TextView title = new TextView(this);
                tableRowDesign(title, " title ");
                tr.addView(title);

                TextView client_name = new TextView(this);
                tableRowDesign(client_name, " client_name ");
                tr.addView(client_name);

                TextView service_type = new TextView(this);
                tableRowDesign(service_type, " service_type ");
                tr.addView(service_type);

                TextView amount = new TextView(this);
                tableRowDesign(amount, " amount ");
                tr.addView(amount);

                TextView My_earnings = new TextView(this);
                tableRowDesign(My_earnings, " My_earnings ");
                tr.addView(My_earnings);

                TextView sold_date = new TextView(this);
                tableRowDesign(sold_date, " sold_date ");
                tr.addView(sold_date);

                TextView status = new TextView(this);
                tableRowDesign(status, " Status ");
                tr.addView(status);

                SoldServiceTable.addView(tr);


                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                SoldServiceTable.addView(vline1);  // add line below each row
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