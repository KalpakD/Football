package com.example.kalpak.football.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpak.football.R;
import com.example.kalpak.football.activities.PlayersListActivity;
import com.example.kalpak.football.databinding.TeamRowBinding;
import com.example.kalpak.football.models.Team;
import com.example.kalpak.football.viewmodels.ViewTeam;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.BindingHolder> {


    private List<Team> sports;
    private Context context;

    public TeamListAdapter(List<Team> sports, Context context) {
        this.sports = sports;
        this.context = context;
    }


    @NonNull
    @Override
    public TeamListAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TeamRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.team_row, parent, false);
        return new TeamListAdapter.BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamListAdapter.BindingHolder holder, final int position) {
        TeamRowBinding binding = holder.binding;
        binding.setTeam(new ViewTeam(context, sports.get(position)));
        final Team model = sports.get(position);

        binding.teamlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayersListActivity.class);
                intent.putExtra("team_detail", model);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    class BindingHolder extends RecyclerView.ViewHolder {

        TeamRowBinding binding;

        BindingHolder(TeamRowBinding binding) {
            super(binding.teamlist);
            this.binding = binding;
        }


    }
}
