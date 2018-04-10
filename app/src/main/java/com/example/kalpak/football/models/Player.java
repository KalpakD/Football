package com.example.kalpak.football.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private String idPlayer;
    private String strNationality;
    private String strPlayer;
    private String strTeam;
    private String dateBorn;
    private String strDescriptionEN;
    private String strPosition;
    private String strThumb;
    private String strCutout;
    private String strFanart1;

    public Player(Player player) {
        this.dateBorn = player.dateBorn;
        this.idPlayer = player.idPlayer;
        this.strCutout = player.strCutout;
        this.strDescriptionEN = player.strDescriptionEN;
        this.strFanart1 = player.strFanart1;
        this.strNationality = player.strNationality;
        this.strPlayer = player.strPlayer;
        this.strPosition = player.strPosition;
        this.strTeam = player.strTeam;
        this.strThumb = player.strThumb;

    }

    private Player(Parcel in) {
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


    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
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
