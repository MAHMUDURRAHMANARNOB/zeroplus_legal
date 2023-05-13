package com.zeroplus.zeroplus_legal.Earnings;

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

public class WithdrawHistory extends AppCompatActivity {

    private TableLayout WithdrawsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_history);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Withdraw History");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WithdrawHistory.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        WithdrawsTable=(TableLayout)findViewById(R.id.tableWithdraws);
        TableLayout();
    }

    public void TableLayout(){

        WithdrawsTable.removeAllViewsInLayout();
        int flag=1;

        for (int i=-1; i<10; i++) {

            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            if (flag == 1) {

                TextView Requested_amount = new TextView(this);
                tableHeaderDesign(Requested_amount, " Requested Amount ");
                tr.addView(Requested_amount);

                TextView Paid_Amount = new TextView(this);
                tableHeaderDesign(Paid_Amount, " Paid Amount ");
                tr.addView(Paid_Amount);

                TextView Payment_Method = new TextView(this);
                tableHeaderDesign(Payment_Method, " Payment Method ");
                tr.addView(Payment_Method);

                TextView Date = new TextView(this);
                tableHeaderDesign(Date, " Date ");
                tr.addView(Date);

                TextView Receipt = new TextView(this);
                tableHeaderDesign(Receipt, " Receipt ");
                tr.addView(Receipt);

                TextView Status = new TextView(this);
                tableHeaderDesign(Status, " Status ");
                tr.addView(Status);

                WithdrawsTable.addView(tr);

                final View vline = new View(this);
                vline.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline.setBackgroundColor(Color.BLUE);
                WithdrawsTable.addView(vline); // add line below heading
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

                TextView requested_amount = new TextView(this);
                tableRowDesign(requested_amount, " requested_amount ");
                tr.addView(requested_amount);

                TextView paid_amount = new TextView(this);
                tableRowDesign(paid_amount, " paid_amount ");
                tr.addView(paid_amount);

                TextView payment_method = new TextView(this);
                tableRowDesign(payment_method, " payment_method ");
                tr.addView(payment_method);

                TextView date = new TextView(this);
                tableRowDesign(date, " date ");
                tr.addView(date);

                TextView receipt = new TextView(this);
                tableRowDesign(receipt, " receipt ");
                tr.addView(receipt);

                TextView status = new TextView(this);
                tableRowDesign(status, " status ");
                tr.addView(status);

                WithdrawsTable.addView(tr);


                final View vline1 = new View(this);
                vline1.setLayoutParams(new
                        TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
                vline1.setBackgroundColor(Color.BLACK);
                WithdrawsTable.addView(vline1);  // add line below each row
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