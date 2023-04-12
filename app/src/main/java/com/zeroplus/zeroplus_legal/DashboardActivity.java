package com.zeroplus.zeroplus_legal;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.zeroplus.zeroplus_legal.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDashboardBinding binding;

    DrawerLayout drawerDashboard;
    NavigationView navigationView;
    ImageView three_dot;
    Toolbar custoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerDashboard,custoolbar,R.string.Open_nav,R.string.close_nav);
        drawerDashboard.addDrawerListener(toggle);
        toggle.syncState();


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
}