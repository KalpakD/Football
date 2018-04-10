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
import com.example.kalpak.football.adapters.PlayerListAdapter;
import com.example.kalpak.football.adapters.TeamListAdapter;
import com.example.kalpak.football.databinding.ActivityPlayersListBinding;
import com.example.kalpak.football.databinding.ActivityTeamListBinding;
import com.example.kalpak.football.models.League;
import com.example.kalpak.football.models.Player;
import com.example.kalpak.football.models.Team;
import com.example.kalpak.football.utils.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.kalpak.football.utils.Constants.ALL_PLAYERS;
import static com.example.kalpak.football.utils.Constants.ALL_TEAMS;
import static com.example.kalpak.football.utils.Constants.BASE_URL;

public class PlayersListActivity extends AppCompatActivity {
    ActivityPlayersListBinding binding;
    List<Player> sports = new ArrayList<>();
    PlayerListAdapter sportsAdapter;
    String teamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final Team team = intent.getParcelableExtra("team_detail");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_players_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.pcontainer.playerList.setNestedScrollingEnabled(false);
        binding.pcontainer.playerList.setLayoutManager(layoutManager);
        sportsAdapter = new PlayerListAdapter(sports, PlayersListActivity.this);

        binding.toolbar.setTitle("Players");
        teamId = team.getIdTeam();
        binding.pcontainer.playerList.setAdapter(sportsAdapter);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlayersListActivity.this, TeamDetailActivity.class);
                intent1.putExtra("team_detail", team);
                startActivity(intent1);
            }
        });
        Glide.with(this)
                .load(team.getStrTeamLogo()).centerCrop()
                .into(binding.teamheader);
        response();
    }

    public void response() {


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + ALL_PLAYERS + teamId, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                    JSONArray array = response.getJSONArray("player");


                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < array.length(); i++) {

                        sports.add(new Player(gson.fromJson(array.getJSONObject(i).toString(), Player.class)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.pcontainer.playerList.setAdapter(sportsAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                NetworkResponse response = error.networkResponse;
                Toast.makeText(PlayersListActivity.this, "response: Error" +
                        response.statusCode, Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

    }
}
