package com.example.kalpak.football.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.kalpak.football.R;
import com.example.kalpak.football.adapters.EventsAdapter;
import com.example.kalpak.football.databinding.FragmentEventsTodayBinding;
import com.example.kalpak.football.models.Events;
import com.example.kalpak.football.utils.DateTime;
import com.example.kalpak.football.utils.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.kalpak.football.utils.Constants.BASE_URL;
import static com.example.kalpak.football.utils.Constants.EVENTS_TODAY;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsTodayFragment extends Fragment {
    FragmentEventsTodayBinding binding;
    List<Events> event = new ArrayList<>();
    EventsAdapter eventsAdapter;

    public EventsTodayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events_today, container, false);
        binding = FragmentEventsTodayBinding.bind(view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.eventList.setLayoutManager(layoutManager);
        eventsResponse(view);
        eventsAdapter = new EventsAdapter(event, view.getContext());

        return view;
    }

    public void eventsResponse(final View view) {


        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL + EVENTS_TODAY + DateTime.getCurrentData() + "&s=Soccer", null, new Response.Listener<JSONObject>() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = response.getJSONArray("events");
                    Gson gson = new GsonBuilder().create();

                    for (int i = 0; i < array.length(); i++) {
                        Events events = gson.fromJson(array.getJSONObject(i).toString(), Events.class);
                        Events addevents = new Events(events);


                        event.add(addevents);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                binding.eventList.setAdapter(eventsAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                NetworkResponse response = error.networkResponse;
                Toast.makeText(view.getContext(), "response: Error" +
                        response.statusCode, Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(view.getContext()).addToRequestQueue(jsObjRequest);

    }


}
