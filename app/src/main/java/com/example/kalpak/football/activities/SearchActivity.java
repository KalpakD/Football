package com.example.kalpak.football.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.kalpak.football.adapters.PlayerListAdapter;
import com.example.kalpak.football.adapters.TeamListAdapter;
import com.example.kalpak.football.databinding.ActivitySearchBinding;

import com.example.kalpak.football.R;
import com.example.kalpak.football.models.Player;
import com.example.kalpak.football.models.Team;
import com.example.kalpak.football.utils.Constants;
import com.example.kalpak.football.utils.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.kalpak.football.utils.Constants.BASE_URL;
import static com.example.kalpak.football.utils.Constants.SEARCH_LEAGUE;
import static com.example.kalpak.football.utils.Constants.SEARCH_PLAYER_NAME;
import static com.example.kalpak.football.utils.Constants.SEARCH_TEAM_PLAYER;


public class SearchActivity extends AppCompatActivity {
    List<Team> sports = new ArrayList<>();
    List<Player> players = new ArrayList<>();

    TeamListAdapter sportsAdapter;
    PlayerListAdapter playerListAdapter;
    ActivitySearchBinding binding;
    String search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recycler.setLayoutManager(layoutManager);
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        binding.search.setQuery(query, true);

        if (Constants.SEARCH_FLAG == 1) {
            search = SEARCH_LEAGUE;
            binding.search.setQueryHint("Search Team");
            sportsAdapter = new TeamListAdapter(sports, SearchActivity.this);
            response(query);

        } else {
            binding.search.setQueryHint("Search by Team");
            playerListAdapter = new PlayerListAdapter(players, SearchActivity.this);

            if (Constants.SEARCH_FLAG == 2) {
                search = SEARCH_TEAM_PLAYER;
                response1(query);

            } else {
                search = SEARCH_PLAYER_NAME;
                binding.search.setQueryHint("Search Player");
                response1(query);
            }

        }
        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) {
                    //call api
                    if (Constants.SEARCH_FLAG == 2) {
                        response(query);
                    } else {
                        response1(query);
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sports.clear();
                players.clear();
                if (Constants.SEARCH_FLAG == 1) {
                    response(newText);
                } else {
                    response1(newText);
                }
                return false;
            }
        });

    }

    public void response(String query) {


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + SEARCH_LEAGUE + query + "&s=Soccer", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("teams");


                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < array.length(); i++) {

                        sports.add(new Team(gson.fromJson(array.getJSONObject(i).toString(), Team.class)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.recycler.setAdapter(sportsAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                NetworkResponse response = error.networkResponse;
                Toast.makeText(SearchActivity.this, "response: Error" +
                        response.statusCode, Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

    }

    public void response1(String query) {


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + search + query, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("player");


                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < array.length(); i++) {

                        players.add(new Player(gson.fromJson(array.getJSONObject(i).toString(), Player.class)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.recycler.setAdapter(playerListAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                NetworkResponse response = error.networkResponse;
                Toast.makeText(SearchActivity.this, "response: Error" +
                        response.statusCode, Toast.LENGTH_SHORT).show();

            }
        });
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

    }

}
