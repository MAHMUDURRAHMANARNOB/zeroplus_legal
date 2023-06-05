package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.DashboardActivity;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.RecyclerViewInterface;
import com.zeroplus.zeroplus_legal.lawChamber.DetailedViews.Details_ZeroplusCase;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_zpCases;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_zpCases;

import java.util.ArrayList;
import java.util.List;

public class zpCases extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView ZPCASESRV;
    private RecyclerView.Adapter adapter;
    private List<list_zpCases> zpcases_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zp_cases);

        /*TOOL_BAR*/
        Toolbar toolbar = findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn = findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Zeroplus Cases");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(zpCases.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });

        setSupportActionBar(toolbar);
        /*Toolbar End*/

        ZPCASESRV = (RecyclerView) findViewById(R.id.RVZP_CASES);
        ZPCASESRV.setHasFixedSize(true);
        ZPCASESRV.setLayoutManager(new LinearLayoutManager(this));

        zpcases_list = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            list_zpCases zpcases1 = new list_zpCases(
                    "Mostafijur Rahman Jamalpur Land File", "mosta-01-2023",
                    "mosta-01-2023", "29/03/2023", "Open",
                    "Close", "Plaintiff");
            list_zpCases zpcases2 = new list_zpCases(
                    "Raju Khilkhet", "raju-2023",
                    "raju-2023", "29/03/2023", "Judgement",
                    "Open", "Opponent");

            zpcases_list.add(zpcases1);
            zpcases_list.add(zpcases2);
        }
        adapter = new adapter_zpCases(this, zpcases_list, this);
        ZPCASESRV.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, Details_ZeroplusCase.class);

        intent.putExtra("FileName",zpcases_list.get(position).getFileName());
        intent.putExtra("FileNo",zpcases_list.get(position).getFileNo());
        intent.putExtra("CaseNo",zpcases_list.get(position).getCaseNo());
        intent.putExtra("CaseStatus",zpcases_list.get(position).getCaseStatus());
        intent.putExtra("Judgement",zpcases_list.get(position).getJudgementStatus());
        intent.putExtra("FilingDate",zpcases_list.get(position).getFilingDate());
        intent.putExtra("ClientType",zpcases_list.get(position).getPosition());
        startActivity(intent);
    }
}