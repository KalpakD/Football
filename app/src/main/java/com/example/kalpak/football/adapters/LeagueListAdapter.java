package com.example.kalpak.football.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpak.football.R;
import com.example.kalpak.football.activities.TeamListActivity;
import com.example.kalpak.football.databinding.LeagueRowBinding;
import com.example.kalpak.football.models.League;
import com.example.kalpak.football.viewmodels.ViewLeague;

import java.util.List;

public class LeagueListAdapter extends RecyclerView.Adapter<LeagueListAdapter.BindingHolder> {


private List<League> sports;
private Context context;

public LeagueListAdapter(List<League> sports, Context context) {
        this.sports = sports;
        this.context = context;
        }


@Override
public LeagueListAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LeagueRowBinding binding = DataBindingUtil.inflate( LayoutInflater.from(parent.getContext()),
        R.layout.league_row,parent,false);
        return new LeagueListAdapter.BindingHolder(binding);
        }

@Override
public void onBindViewHolder(LeagueListAdapter.BindingHolder holder, final int position) {
    LeagueRowBinding binding = holder.binding;
        binding.setLeague(new ViewLeague(context,sports.get(position)));
        final League model=sports.get(position);

        binding.leaguelist.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), TeamListActivity.class);
                intent.putExtra("League_detail", (Parcelable) model);
                v.getContext().startActivity(intent);
        }
        });

        }

@Override
public int getItemCount() {
        return sports.size();
        }

public class BindingHolder extends RecyclerView.ViewHolder {

    LeagueRowBinding binding;

    public BindingHolder( LeagueRowBinding binding) {
        super(binding.leaguelist);
        this.binding = binding;
    }


}

}
