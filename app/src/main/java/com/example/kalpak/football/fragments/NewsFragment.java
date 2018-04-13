package com.example.kalpak.football.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpak.football.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
//https://newsapi.org/v2/top-headlines?sources=four-four-two&apiKey=13da038b545446aeb6c8698588d84c29

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

}
