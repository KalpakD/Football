package com.example.kalpak.football.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpak.football.R;
import com.example.kalpak.football.databinding.EventsRowBinding;
import com.example.kalpak.football.models.Events;
import com.example.kalpak.football.viewmodels.ViewEvents;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.BindingHolder> {


    private List<Events> events;
    private Context context;

    public EventsAdapter(List<Events> events, Context context) {
        this.events = events;
        this.context = context;
    }


    @NonNull
    @Override
    public EventsAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventsRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.events_row, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.BindingHolder holder, int position) {
        EventsRowBinding binding = holder.binding;
        binding.setEvent(new ViewEvents(context, events.get(position)));
        final Events eventsmodel = events.get(position);

        binding.eventsCard.setOnClickListener(new View.OnClickListener() {
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

        public EventsRowBinding binding;


        BindingHolder(EventsRowBinding binding) {
            super(binding.eventsCard);
            this.binding = binding;

        }


    }
}