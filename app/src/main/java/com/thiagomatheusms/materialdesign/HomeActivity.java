package com.thiagomatheusms.materialdesign;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.thiagomatheusms.materialdesign.Adapter.AdapterHomeActivity;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationMenu;

    private RecyclerView mRecyclerViewRestaurants, mRecyclerViewRestaurants2;

    private AdapterHomeActivity adapterHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Views
        this.mRecyclerViewRestaurants = findViewById(R.id.recyclerView_restaurants);
        this.mRecyclerViewRestaurants.setHasFixedSize(true);

        this.mRecyclerViewRestaurants2 = findViewById(R.id.recyclerView_restaurants2);
        this.mRecyclerViewRestaurants2.setHasFixedSize(true);

        this.mBottomNavigationMenu = findViewById(R.id.bottom_navigation_view);

        //Bottom navigation view
        mBottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.bottom_menu_home: {
                        Toast.makeText(getBaseContext(), "HOME", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.bottom_menu_favorites: {
                        Toast.makeText(getBaseContext(), "FAVORITES", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.bottom_menu_profile: {
                        Toast.makeText(getBaseContext(), "PROFILE", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return true;
            }
        });


        //Adapter RecyclerView
        adapterHomeActivity = new AdapterHomeActivity();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewRestaurants.setLayoutManager(layoutManager);
        mRecyclerViewRestaurants.setAdapter(adapterHomeActivity);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerViewRestaurants2.setLayoutManager(layoutManager2);
        mRecyclerViewRestaurants2.setAdapter(adapterHomeActivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemSelected = item.getItemId();

        switch (menuItemSelected) {

            case R.id.action_bar_menu_search:
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}
