package com.example.kalpak.football.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.kalpak.football.models.Events;

public class ViewEvents extends BaseObservable {


    private Events events;

    public ViewEvents(Context context, Events events) {
        Context context1 = context;
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
    public String getIntHomeScore() {
        return events.getIntHomeScore();
    }

    @Bindable
    public String getIntAwayScore() {
        return events.getIntAwayScore();
    }


    @Bindable
    public String getIdLeague() {
        return events.getIdLeague();
    }


}
