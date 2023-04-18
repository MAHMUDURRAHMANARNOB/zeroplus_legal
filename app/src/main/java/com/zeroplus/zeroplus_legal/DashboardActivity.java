package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.zeroplus.zeroplus_legal.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDashboardBinding binding;
    SharedPreferences prf;


    DrawerLayout drawerDashboard;
    NavigationView navigationView;
    ImageView three_dot;
    Toolbar custoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prf = this.getSharedPreferences(SessionManager.SESSION_REMEMBERME,0);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*Hooks*/
        drawerDashboard = findViewById(R.id.dashboard_drawer);
        navigationView = findViewById(R.id.nav_view);
        custoolbar = findViewById(R.id.homeTool);

//        getSupportActionBar().hide();
        three_dot = findViewById(R.id.tool_menu);

        /*Toolbar*/
        setSupportActionBar(custoolbar);

        three_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DrawerLayout navDrawer = findViewById(R.id.drawer_layout);
                // If the navigation drawer is not open then open it, if its already open then close it.
                if(!drawerDashboard.isDrawerOpen(GravityCompat.START)) {
                    drawerDashboard.openDrawer(GravityCompat.START);
                }

                else {drawerDashboard.closeDrawer(GravityCompat.END);}
            }
        });


        /*navigation drawer menu*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerDashboard,custoolbar,R.string.Open_nav,R.string.close_nav);
        drawerDashboard.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.itemDashboard);


        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.itemDashboard);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onBackPressed(){
        if(drawerDashboard.isDrawerOpen(GravityCompat.START)){
            drawerDashboard.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemDashboard:
                /*Intent Dashintent = new Intent(this,DashboardActivity.class);
                startActivity(Dashintent);*/
                Toast.makeText(this,"Dashboard", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemPackages:
                Intent PackagesInt = new Intent(this,Packages.class);
                startActivity(PackagesInt);
//                Toast.makeText(this,"itemPackages", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemAccSettings:
                Intent AccSettInt = new Intent(this,AccountSettingsActivity.class);
                startActivity(AccSettInt);
//                Toast.makeText(this,"itemAccSettings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemProSettings:
                Intent ProSettInt = new Intent(this,ProfileSettingsActivity.class);
                startActivity(ProSettInt);
//                Toast.makeText(this,"profile Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemLogout:
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();

                Intent Logintent = new Intent(this,
                        MainActivity.class);
                Logintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Logintent);
                this.finish();
                break;

        }

        drawerDashboard.closeDrawer(GravityCompat.START);

        return true;
    }
}