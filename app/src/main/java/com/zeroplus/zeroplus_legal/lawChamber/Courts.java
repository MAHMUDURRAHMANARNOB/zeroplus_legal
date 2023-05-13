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
import com.zeroplus.zeroplus_legal.R;

public class Courts extends AppCompatActivity {

    private TableLayout CourtsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courts);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Courts");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Courts.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        CourtsTable=(TableLayout)findViewById(R.id.tableCourts);
        TableLayout();

    }

    public void TableLayout(){

        CourtsTable.removeAllViewsInLayout();
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
                tableHeaderDesign(Phone, " Email ");
                tr.addView(Phone);

                TextView Location = new TextView(this);
                tableHeaderDesign(Location, " Location ");
                tr.addView(Location);

                TextView Category = new TextView(this);
                tableHeaderDesign(Category, " Category ");
                tr.addView(Category);

                TextView Country = new TextView(this);
                tableHeaderDesign(Country, " Country ");
                tr.addView(Country);

                TextView City = new TextView(this);
                tableHeaderDesign(City, " City ");
                tr.addView(City);

                TextView Room_No = new TextView(this);
                tableHeaderDesign(Room_No, " Room No ");
                tr.addView(Room_No);

                TextView Description = new TextView(this);
                tableHeaderDesign(Description, " Description ");
                tr.addView(Description);

                CourtsTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                CourtsTable.addView(vline); // add line below heading
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

                TextView email = new TextView(this);
                tableRowDesign(email, " email ");
                tr.addView(email);

                TextView location = new TextView(this);
                tableRowDesign(location, " location ");
                tr.addView(location);

                TextView category = new TextView(this);
                tableRowDesign(category, " category ");
                tr.addView(category);

                TextView country = new TextView(this);
                tableRowDesign(country, " country ");
                tr.addView(country);

                TextView city = new TextView(this);
                tableRowDesign(city, " city ");
                tr.addView(city);

                TextView room_no = new TextView(this);
                tableRowDesign(room_no, " room_no ");
                tr.addView(room_no);

                TextView description = new TextView(this);
                tableRowDesign(description, " description ");
                tr.addView(description);

                CourtsTable.addView(tr);


                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                CourtsTable.addView(vline1);  // add line below each row
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