package com.example.kalpak.football.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpak.football.R;
import com.example.kalpak.football.databinding.ScoreRowBinding;
import com.example.kalpak.football.models.Events;
import com.example.kalpak.football.viewmodels.ViewEvents;

import java.util.List;


public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.BindingHolder> {



    private List<Events> events;
    private Context context;

    public ScoreAdapter(List<Events> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ScoreRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.score_row, parent, false);
        return new ScoreAdapter.BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.BindingHolder holder, int position) {
        ScoreRowBinding binding = holder.binding;
        binding.setScore(new ViewEvents(context, events.get(position)));
        Events eventsmodel = events.get(position);

        binding.scoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder {

        ScoreRowBinding binding;
        public BindingHolder(ScoreRowBinding binding) {
            super(binding.scoreCard);
            this.binding = binding;

        }
    }
}
