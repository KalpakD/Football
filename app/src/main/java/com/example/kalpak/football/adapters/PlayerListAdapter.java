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
import com.example.kalpak.football.activities.PlayerDetailActivity;
import com.example.kalpak.football.databinding.PlayerRowBinding;

import com.example.kalpak.football.models.Player;

import com.example.kalpak.football.viewmodels.ViewPlayer;


import java.util.List;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.BindingHolder> {


    private List<Player> sports;
    private Context context;

    public PlayerListAdapter(List<Player> sports, Context context) {
        this.sports = sports;
        this.context = context;
    }


    @Override
    public PlayerListAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PlayerRowBinding binding = DataBindingUtil.inflate( LayoutInflater.from(parent.getContext()),
                R.layout.player_row,parent,false);
        return new PlayerListAdapter.BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(PlayerListAdapter.BindingHolder holder, final int position) {
        PlayerRowBinding binding = holder.binding;
        binding.setPlayer(new ViewPlayer(context,sports.get(position)));
        final Player model=sports.get(position);

        binding.playerlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), PlayerDetailActivity.class);
                intent.putExtra("player_detail", (Parcelable) model);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {

        PlayerRowBinding binding;

        public BindingHolder( PlayerRowBinding binding) {
            super(binding.playerlist);
            this.binding = binding;
        }


    }
}
