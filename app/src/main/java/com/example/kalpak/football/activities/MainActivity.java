package com.example.kalpak.football.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.kalpak.football.R;
import com.example.kalpak.football.databinding.ActivityMainBinding;
import com.example.kalpak.football.fragments.EventsTodayFragment;
import com.example.kalpak.football.fragments.LeagueListFragment;
import com.example.kalpak.football.fragments.PastEventFragment;
import com.example.kalpak.football.utils.Constants;
import com.example.kalpak.football.utils.NetworkChangeReceiver;
import com.example.kalpak.football.utils.NetworkUtil;

import static com.example.kalpak.football.utils.Constants.CONNECTIVITY_ACTION;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    MenuItem menuItem;
    IntentFilter intentFilter;
    NetworkChangeReceiver receiver;
//    private static TextView log_network;
    private static String log_str;

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    binding.included.toolbar.setTitleTextColor(R.color.color_white);
                    binding.included.toolbarTitle.setText(R.string.leagues);
                    Constants.SEARCH_FLAG=1;
                    fragment = new LeagueListFragment();
                    break;
                case R.id.navigation_dashboard:
                    binding.included.toolbar.setTitleTextColor(R.color.color_white);
                    binding.included.toolbarTitle.setText(R.string.events_today);
                    Constants.SEARCH_FLAG=2;
                    fragment = new EventsTodayFragment();
                    break;
                case R.id.navigation_notifications:
                    binding.included.toolbar.setTitleTextColor(R.color.color_white);
                    binding.included.toolbarTitle.setText(R.string.past_events);
                    Constants.SEARCH_FLAG=3;
                    fragment = new PastEventFragment();
                    break;
            }
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                setSupportActionBar(binding.included.toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setHomeButtonEnabled(false);
                getSupportActionBar().setTitle("");
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            } return true;
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            intentFilter = new IntentFilter();
            intentFilter.addAction(CONNECTIVITY_ACTION);
            receiver = new NetworkChangeReceiver();

            if (NetworkUtil.getConnectivityStatus(MainActivity.this) > 0 ) {
                binding.navigation.setSelectedItemId(R.id.navigation_home);
            }
            else {
                Snackbar.make(binding.container, "Please check Your Connection", Snackbar.LENGTH_LONG).show();

            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            menuItem = menu.findItem(R.id.menu_settings);
            menuItem.setVisible(true);
            final MenuItem myActionMenuItem = menu.findItem( R.id.menu_search);
            final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
            searchView.setQueryHint("Team Name");
            final SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);


            ArrayAdapter<String> newsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Constants.dataArr);
            searchAutoComplete.setAdapter(newsAdapter);

            searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int itemIndex, long id) {
                    String queryString=(String)adapterView.getItemAtPosition(itemIndex);
                    searchAutoComplete.setText("" + queryString);


                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    // Toast like print
                    Intent intent=new Intent(MainActivity.this, SearchActivity.class);
                    intent.putExtra("query",query);
                    startActivity(intent);
                    myActionMenuItem.collapseActionView();
                    return true;
                }
                @Override
                public boolean onQueryTextChange(String s) {
                    Intent intent=new Intent(MainActivity.this, SearchActivity.class);
                    intent.putExtra("query",s);
                    startActivity(intent);
                    myActionMenuItem.collapseActionView();
                    return false;
                }
            });
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_settings:


                    break;
                case R.id.menu_search:

                    break;

            }
            return true;
        }

    }
