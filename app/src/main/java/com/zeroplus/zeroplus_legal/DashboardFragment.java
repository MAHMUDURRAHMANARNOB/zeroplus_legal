package com.zeroplus.zeroplus_legal;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.zeroplus.zeroplus_legal.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    DrawerLayout drawerDashboard;
    NavigationView navigationView;
    TextView zcode, balance;
    ImageView three_dot;
    Toolbar custoolbar;
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


    }

}