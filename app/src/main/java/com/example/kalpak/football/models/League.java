package com.example.kalpak.football.models;

import android.os.Parcel;
import android.os.Parcelable;

public class League implements Parcelable {


    String idLeague;
    String strCountry;
    String strDescriptionEN;
    String strBadge;
    String strLeague;
    String strLogo;
    String strTrophy;
    String strFanart1;

    public League(League league) {
        this.idLeague=league.idLeague;
        this.strBadge=league.strBadge;
        this.strCountry=league.strCountry;
        this.strDescriptionEN=league.strDescriptionEN;
        this.strFanart1=league.strFanart1;
        this.strLeague=league.strLeague;
        this.strLogo=league.strLogo;
        this.strTrophy=league.strTrophy;
    }

    protected League(Parcel in) {
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

    public League() {

    }

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

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public void setStrLogo(String strLogo) {
        this.strLogo = strLogo;
    }

    public void setStrTrophy(String strTrophy) {
        this.strTrophy = strTrophy;
    }

    public void setStrFanart1(String strFanart1) {
        this.strFanart1 = strFanart1;
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
