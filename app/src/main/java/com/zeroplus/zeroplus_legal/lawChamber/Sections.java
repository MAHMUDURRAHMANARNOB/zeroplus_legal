package com.zeroplus.zeroplus_legal.lawChamber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.Earnings.Models.list_Earnings;
import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.adapter_sections;
import com.zeroplus.zeroplus_legal.lawChamber.Modals.list_sections;

import java.util.ArrayList;
import java.util.List;

public class Sections extends AppCompatActivity {

    private RecyclerView RVSections;
    private RecyclerView.Adapter adapter;
    private List<list_sections> sections_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        /*TOOL_BAR*/
        Toolbar toolbar =  findViewById(R.id.toolbar_for_activities);
        TextView toolbarTextView = (TextView) findViewById(R.id.Cus_tool_text);
        ImageButton backBtn =  findViewById(R.id.imgbtnBack);
        toolbarTextView.setText("Sections");

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sections.this, DashboardActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        });
        setSupportActionBar(toolbar);
        /*Toolbar End*/

        Button btnSectionsSetup = (Button) findViewById(R.id.btnSectionsSetup);
        btnSectionsSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myServiceInt = new Intent(Sections.this, com.zeroplus.zeroplus_legal.Setup.SectionSetup.class);
                startActivity(myServiceInt);
            }
        });

        RVSections = (RecyclerView) findViewById(R.id.RVSections);
        RVSections.setHasFixedSize(true);
        RVSections.setLayoutManager(new LinearLayoutManager(this));

        sections_List = new ArrayList<>();

        for (int i = 0; i<10; i++){
            list_sections sections = new list_sections(
                    "Article 15" ,"Article 14 in The Constitution Of India 1949\n" +
                    "14. Equality before law The State shall not deny to any person equality before the law or the equal protection of the laws within the territory of India Prohibition of discrimination on grounds of religion, race, caste, sex or place of birth."
            );

            sections_List.add(sections);
        }
        adapter = new adapter_sections(sections_List,this);
        RVSections.setAdapter(adapter);

    }
}