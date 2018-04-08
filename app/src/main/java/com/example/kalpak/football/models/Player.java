package com.example.kalpak.football.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable{
    String idPlayer;
    String strNationality;
    String strPlayer;
    String strTeam;
    String dateBorn;
    String strDescriptionEN;
    String strPosition;
    String strThumb;
    String strCutout;
    String strFanart1;

    public Player(Player player) {
        this.dateBorn= player.dateBorn;
        this.idPlayer= player.idPlayer;
        this.strCutout= player.strCutout;
        this.strDescriptionEN= player.strDescriptionEN;
        this.strFanart1= player.strFanart1;
        this.strNationality= player.strNationality;
        this.strPlayer= player.strPlayer;
        this.strPosition= player.strPosition;
        this.strTeam= player.strTeam;
        this.strThumb= player.strThumb;

    }

    protected Player(Parcel in) {
        idPlayer = in.readString();
        strNationality = in.readString();
        strPlayer = in.readString();
        strTeam = in.readString();
        dateBorn = in.readString();
        strDescriptionEN = in.readString();
        strPosition = in.readString();
        strThumb = in.readString();
        strCutout = in.readString();
        strFanart1 = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getIdPlayer() {
        return idPlayer;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public String getStrFanart1() {
        return strFanart1;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public void setStrCutout(String strCutout) {
        this.strCutout = strCutout;
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
        dest.writeString(idPlayer);
        dest.writeString(strNationality);
        dest.writeString(strPlayer);
        dest.writeString(strTeam);
        dest.writeString(dateBorn);
        dest.writeString(strDescriptionEN);
        dest.writeString(strPosition);
        dest.writeString(strThumb);
        dest.writeString(strCutout);
        dest.writeString(strFanart1);
    }
}
