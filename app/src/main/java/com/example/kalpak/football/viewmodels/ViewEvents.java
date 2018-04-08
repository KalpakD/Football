package com.example.kalpak.football.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kalpak.football.models.Events;

public class ViewEvents extends BaseObservable {


    private Context context;
    private Events events;

    public ViewEvents(Context context, Events events) {
        this.context = context;
        this.events = events;
    }

    @Bindable
    public String getIdEvent() {
        return events.getIdEvent();
    }

    public void setIdEvent(String idEvent) {
        events.setIdEvent(idEvent);

    }

    @Bindable
    public String getStrEvent() {
        return events.getStrEvent();
    }

    public void setStrEvent(String strEvent) {
        events.setStrEvent(strEvent);
    }

    @Bindable
    public String getStrHomeTeam() {
        return events.getStrHomeTeam();
    }

    public void setStrHomeTeam(String strHomeTeam) {
        events.setStrHomeTeam(strHomeTeam);
    }

    @Bindable
    public String getStrAwayTeam() {
        return events.getStrAwayTeam();
    }

    public void setStrAwayTeam(String strAwayTeam) {
        events.setStrAwayTeam(strAwayTeam);
    }

    @Bindable
    public String getDateEvent() {
        return events.getDateEvent();
    }

    public void setDateEvent(String dateEvent) {
        events.setDateEvent(dateEvent);
    }

    @Bindable
    public String getStrTime() {
        return events.getStrTime();
    }

    public void setStrTime(String strTime) {
        events.setStrTime(strTime);
    }

    @Bindable
    public String getStrLeague() {
        return events.getStrLeague();
    }

    public void setStrLeague(String strLeague) {
        events.setStrTime(strLeague);
    }

    @Bindable
    public String getIdHomeTeam() {
        return events.getIdHomeTeam();
    }

    public void setIdHomeTeam(String idHomeTeam) {
        events.setIdHomeTeam(idHomeTeam);
    }

    @Bindable
    public String getIdAwayTeam() {
        return events.getIdAwayTeam();
    }

    public void setIdAwayTeam(String idAwayTeam) {
        events.setIdAwayTeam(idAwayTeam);
    }


    @BindingAdapter({"badge"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop()
                .into(view);
    }

    @Bindable
    public String getIntHomeScore() {
        return events.getIntHomeScore();
    }

    //    public void setIntHomeScore(String intHomeScore) {
//        this.intHomeScore = intHomeScore;
//    }
    @Bindable
    public String getIntAwayScore() {
        return events.getIntAwayScore();
    }

    //    public void setIntAwayScore(String intAwayScore) {
//        this.intAwayScore = intAwayScore;
//    }
    @Bindable
    public String getIdLeague() {
        return events.getIdLeague();
    }


}
