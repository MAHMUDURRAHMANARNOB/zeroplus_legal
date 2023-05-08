package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.zeroplus.zeroplus_legal.databinding.FragmentDashboardBinding;
import com.zeroplus.zeroplus_legal.lawChamber.MyServices;
import com.zeroplus.zeroplus_legal.lawChamber.ServiceRequest;
import com.zeroplus.zeroplus_legal.lawChamber.SoldServices;

public class DashboardFragment extends Fragment {

    DrawerLayout drawerDashboard;
    NavigationView navigationView;
    TextView zcode, balance;
    ImageView three_dot;
    Toolbar custoolbar;

    ImageButton MyService, SoldService, ServiceReq, MyClients, ZPCases, PersonalCases, PanelLawyers, Courts, Sections;
    private FragmentDashboardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        zcode = view.findViewById(R.id.txtzcode);
        balance = view.findViewById(R.id.txtbalance);

        MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        String refer = globalVariable.getlRefer();

        zcode.setText(refer);


        MyService = (ImageButton) view.findViewById(R.id.ibtnMySer);
        SoldService = (ImageButton) view.findViewById(R.id.ibtnSoldSer);
        ServiceReq = (ImageButton) view.findViewById(R.id.ibtnSerReq);
        MyClients = (ImageButton) view.findViewById(R.id.ibtnmyclients);
        ZPCases = (ImageButton) view.findViewById(R.id.ibtnZpCase);
        PersonalCases = (ImageButton) view.findViewById(R.id.ibtnPerCase);
        PanelLawyers = (ImageButton) view.findViewById(R.id.ibtnPanLaw);
        Courts = (ImageButton) view.findViewById(R.id.ibtncourts);
        Sections = (ImageButton) view.findViewById(R.id.ibtnSections);

        MyService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myServiceInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.MyServices.class);
                startActivity(myServiceInt);
            }
        });

        SoldService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent soldServiceInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.SoldServices.class);
                startActivity(soldServiceInt);
            }
        });

        ServiceReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serviceReqInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.ServiceRequest.class);
                startActivity(serviceReqInt);
            }
        });

        MyClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myClientsInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.MyClients.class);
                startActivity(myClientsInt);
            }
        });

        ZPCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent zpCaseInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.zpCases.class);
                startActivity(zpCaseInt);
            }
        });

        PersonalCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent personalCaseInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.personalCases.class);
                startActivity(personalCaseInt);
            }
        });

        PanelLawyers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent panelLawyerInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.panelLawyers.class);
                startActivity(panelLawyerInt);
            }
        });

        Courts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent courtsInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.Courts.class);
                startActivity(courtsInt);
            }
        });

        Sections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sectionsInt = new Intent(getActivity(), com.zeroplus.zeroplus_legal.lawChamber.Sections.class);
                startActivity(sectionsInt);
            }
        });



    }



}