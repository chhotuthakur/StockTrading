package com.nilesh.stocktrading;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private NavController navController;
    private NavHostFragment navHostFragment;
    private BottomNavigationView btm;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up the toolbar as the support action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        btm = findViewById(R.id.bottom_navigation);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        //navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.navigation_trade) {
                    navController.navigate(R.id.homeFragment);
                } else if (item.getItemId() == R.id.navigation_watch) {
                    navController.navigate(R.id.marketWatchFragment);

                }
                else if (item.getItemId() == R.id.navigation_account) {
                    navController.navigate(R.id.portfolioFragment);
                }

                return false;
            }
        });



        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks here
            // Use item.getItemId() to identify the selected menu item
            drawerLayout.closeDrawers();
            return true;
        });


    }

    private void navigateToMarketWatchFragment() {
        navController.navigate(R.id.marketWatchFragment);
    }



//    Button goToMarketWatchButton = findViewById(R.id.goToMarketWatchButton);
//goToMarketWatchButton.setOnClickListener(v -> navigateToMarketWatchFragment());

}