package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;
import com.zeroplus.zeroplus_legal.databinding.FragmentFirst2Binding;

public class First2Fragment extends Fragment {

    SharedPreferences prf;
    private FragmentFirst2Binding binding;
    NavigationBarView bottombar;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirst2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prf = getActivity().getSharedPreferences(SessionManager.SESSION_REMEMBERME,0);



        bottombar = (NavigationBarView) view.findViewById(R.id.bottom_navigation);
        bottombar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {

                    case R.id.itemEarnings:
                        fragment = new EarningsFragment();
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();
                        break;
                    case R.id.itemhome:
                        fragment = new DashboardFragment();
                        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.mainFrame, fragment);
                        ft1.commit();
                        break;
                    case R.id.itemProfile:
                        fragment = new ProfileFragment();
                        FragmentTransaction ft3 = getActivity().getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.mainFrame, fragment);
                        ft3.commit();
                        break;
                    default:

                }

                return true; // return true;
            }
        });
        bottombar.setSelectedItemId(R.id.itemhome);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}