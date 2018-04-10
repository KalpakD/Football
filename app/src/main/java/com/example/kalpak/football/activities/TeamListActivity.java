package com.example.kalpak.football.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.example.kalpak.football.R;
import com.example.kalpak.football.adapters.TeamListAdapter;
import com.example.kalpak.football.databinding.ActivityTeamListBinding;
import com.example.kalpak.football.models.League;
import com.example.kalpak.football.models.Team;
import com.example.kalpak.football.utils.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.kalpak.football.utils.Constants.ALL_TEAMS;
import static com.example.kalpak.football.utils.Constants.BASE_URL;
import static com.example.kalpak.football.utils.Constants.SPORT_LEAGUE;

public class TeamListActivity extends AppCompatActivity {
    ActivityTeamListBinding binding;
    List<Team> sports = new ArrayList<>();
    TeamListAdapter sportsAdapter;
    String leagueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        final League league = intent.getParcelableExtra("League_detail");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.tcontainer.teamList.setNestedScrollingEnabled(false);
        binding.tcontainer.teamList.setLayoutManager(layoutManager);
        sportsAdapter = new TeamListAdapter(sports, TeamListActivity.this);

        binding.toolbar.setTitle("Teams");
        leagueId = league.getIdLeague();
        binding.tcontainer.teamList.setAdapter(sportsAdapter);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(TeamListActivity.this, LeagueDetailActivity.class);
                intent1.putExtra("League_detail", league);
                startActivity(intent1);
            }
        });
        Glide.with(this)
                .load(league.getStrLogo()).centerCrop()
                .into(binding.header);
        response();
    }

    public void response() {


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + ALL_TEAMS + leagueId, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                    JSONArray array = response.getJSONArray("teams");


                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < array.length(); i++) {

                        sports.add(new Team(gson.fromJson(array.getJSONObject(i).toString(), Team.class)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.tcontainer.teamList.setAdapter(sportsAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                NetworkResponse response = error.networkResponse;
                Toast.makeText(TeamListActivity.this, "response: Error" +
                        response.statusCode, Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

    }
}
