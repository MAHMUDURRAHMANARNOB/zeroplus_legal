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

        /*binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(First2Fragment.this)
                        .navigate(R.id.action_First2Fragment_to_SecondFragment);
            }
        });*/
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {

                    case R.id.itemshareMatter:
                        /*fragment = fragmentHome;*/
                        fragment = new ShareMatterWebFragment();
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();
                        break;
                    case R.id.itemdashboard:
                        /*fragment = fragmentClass;*/
                        fragment = new ZeroplusWebviewFragment();
                        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                        ft1.replace(R.id.mainFrame, fragment);
                        ft1.commit();
                        break;
                    case R.id.itemlogout:
                        /*fragment = fragmentDoubts;*/
                        /*fragment = new ;
                        FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.mainFrame, fragment);
                        ft2.commit();*/

                        /*SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember", "flase");
                        editor.apply();

                        String logout = "Logged Out";
                        Toast toast = Toast.makeText(
                                getActivity().getApplicationContext(),
                                Html.fromHtml("<h3><font color='#87CEEB'>"  +logout+  "</font></h3>"),
                                Toast.LENGTH_LONG);

                        // Set the Toast display position layout center
                        toast.setGravity(Gravity.CENTER,0,50);
                        // Finally, show the toast
                        int lengthShort = Toast.LENGTH_SHORT;
                        toast.setDuration(lengthShort);
                        toast.show();*/

                        SharedPreferences.Editor editor = prf.edit();
                        editor.clear();
                        editor.commit();

                        Intent intent = new Intent(getActivity(),
                                MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        getActivity().finish();

                        /*Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();*/
                        break;

                    default:
                        /* fragment = fragmentHome;*/

                }
//                fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();
                return true; // return true;
            }
        });
        binding.bottomNavigation.setSelectedItemId(R.id.itemdashboard);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}