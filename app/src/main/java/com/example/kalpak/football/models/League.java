package com.example.kalpak.football.models;

import android.os.Parcel;
import android.os.Parcelable;

public class League implements Parcelable {


    private String idLeague;
    private String strCountry;
    private String strDescriptionEN;
    private String strBadge;
    private String strLeague;
    private String strLogo;
    private String strTrophy;
    private String strFanart1;

    public League(League league) {
        this.idLeague = league.idLeague;
        this.strBadge = league.strBadge;
        this.strCountry = league.strCountry;
        this.strDescriptionEN = league.strDescriptionEN;
        this.strFanart1 = league.strFanart1;
        this.strLeague = league.strLeague;
        this.strLogo = league.strLogo;
        this.strTrophy = league.strTrophy;
    }

    private League(Parcel in) {
        idLeague = in.readString();
        strCountry = in.readString();
        strDescriptionEN = in.readString();
        strBadge = in.readString();
        strLeague = in.readString();
        strLogo = in.readString();
        strTrophy = in.readString();
        strFanart1 = in.readString();
    }

    public static final Creator<League> CREATOR = new Creator<League>() {
        @Override
        public League createFromParcel(Parcel in) {
            return new League(in);
        }

        @Override
        public League[] newArray(int size) {
            return new League[size];
        }
    };

    public String getIdLeague() {
        return idLeague;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public String getStrLogo() {
        return strLogo;
    }

    public String getStrTrophy() {
        return strTrophy;
    }

    public String getStrFanart1() {
        return strFanart1;
    }


    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }


    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idLeague);
        dest.writeString(strCountry);
        dest.writeString(strDescriptionEN);
        dest.writeString(strBadge);
        dest.writeString(strLeague);
        dest.writeString(strLogo);
        dest.writeString(strTrophy);
        dest.writeString(strFanart1);
    }
}
