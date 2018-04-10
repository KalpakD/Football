package com.example.kalpak.football.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Team implements Parcelable {
    private String idLeague;
    private String idTeam;
    private String strCountry;
    private String strDescriptionEN;
    private String strStadium;
    private String strStadiumDescription;
    private String strStadiumLocation;
    private String strStadiumThumb;
    private String strTeam;
    private String strTeamBadge;
    private String strTeamBanner;
    private String strTeamJersey;
    private String strTeamLogo;
    private String strManager;

    public Team(Team team) {
        this.idLeague = team.idLeague;
        this.idTeam = team.idTeam;
        this.strCountry = team.strCountry;
        this.strDescriptionEN = team.strDescriptionEN;
        this.strManager = team.strManager;
        this.strStadium = team.strStadium;
        this.strStadiumDescription = team.strStadiumDescription;
        this.strStadiumLocation = team.strStadiumLocation;
        this.strStadiumThumb = team.strStadiumThumb;
        this.strTeam = team.strTeam;
        this.strTeamBadge = team.strTeamBadge;
        this.strTeamBanner = team.strTeamBanner;
        this.strTeamJersey = team.strTeamJersey;
        this.strTeamLogo = team.strTeamLogo;
    }

    protected Team(Parcel in) {
        idLeague = in.readString();
        idTeam = in.readString();
        strCountry = in.readString();
        strDescriptionEN = in.readString();
        strStadium = in.readString();
        strStadiumDescription = in.readString();
        strStadiumLocation = in.readString();
        strStadiumThumb = in.readString();
        strTeam = in.readString();
        strTeamBadge = in.readString();
        strTeamBanner = in.readString();
        strTeamJersey = in.readString();
        strTeamLogo = in.readString();
        strManager = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public String getIdLeague() {
        return idLeague;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public String getStrManager() {
        return strManager;
    }


    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idLeague);
        dest.writeString(idTeam);
        dest.writeString(strCountry);
        dest.writeString(strDescriptionEN);
        dest.writeString(strStadium);
        dest.writeString(strStadiumDescription);
        dest.writeString(strStadiumLocation);
        dest.writeString(strStadiumThumb);
        dest.writeString(strTeam);
        dest.writeString(strTeamBadge);
        dest.writeString(strTeamBanner);
        dest.writeString(strTeamJersey);
        dest.writeString(strTeamLogo);
        dest.writeString(strManager);
    }
}
