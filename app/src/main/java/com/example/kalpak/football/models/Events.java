package com.example.kalpak.football.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import com.example.kalpak.football.utils.DateTime;

public class Events implements Parcelable {


    String idEvent;
    String strEvent;
    String strHomeTeam;
    String strAwayTeam;
    String dateEvent;
    String strTime;
    String idHomeTeam;
    String idAwayTeam;
    String strLeague;
    String intHomeScore;
    String intAwayScore;
    String idLeague;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Events(Events events) {
        this.idEvent = events.getIdEvent();
        this.strEvent = events.getStrEvent();
        this.strHomeTeam = events.getStrHomeTeam();
        this.strAwayTeam = events.getStrAwayTeam();
        this.dateEvent = events.getDateEvent();
        this.strTime = events.getStrTime();
        this.strLeague=events.getStrLeague();
        this.idHomeTeam=events.getIdHomeTeam();
        this.idAwayTeam=events.getIdAwayTeam();
        this.intHomeScore=events.getIntHomeScore();
        this.intAwayScore=events.getIntAwayScore();
        this.idLeague=events.getIdLeague();
    }


    protected Events(Parcel in) {
        idEvent = in.readString();
        strEvent = in.readString();
        strHomeTeam = in.readString();
        strAwayTeam = in.readString();
        dateEvent = in.readString();
        strTime = in.readString();
        idHomeTeam = in.readString();
        idAwayTeam = in.readString();
        strLeague = in.readString();
        intHomeScore = in.readString();
        intAwayScore = in.readString();
        idLeague = in.readString();
    }

    public static final Creator<Events> CREATOR = new Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };

    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    public void setIdHomeTeam(String idHomeTeam) {
        this.idHomeTeam = idHomeTeam;
    }

    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    public void setIdAwayTeam(String idAwayTeam) {
        this.idAwayTeam = idAwayTeam;
    }
    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getStrTime() {
        return  new DateTime().convertTime(strTime);
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }


    public String getIntHomeScore() {
        return intHomeScore;
    }

    public void setIntHomeScore(String intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public void setIntAwayScore(String intAwayScore) {
        this.intAwayScore = intAwayScore;
    }
    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idEvent);
        dest.writeString(strEvent);
        dest.writeString(strHomeTeam);
        dest.writeString(strAwayTeam);
        dest.writeString(dateEvent);
        dest.writeString(strTime);
        dest.writeString(idHomeTeam);
        dest.writeString(idAwayTeam);
        dest.writeString(strLeague);
        dest.writeString(intHomeScore);
        dest.writeString(intAwayScore);
        dest.writeString(idLeague);
    }
}
