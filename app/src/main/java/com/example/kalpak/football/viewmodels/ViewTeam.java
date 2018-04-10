package com.example.kalpak.football.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kalpak.football.models.Team;

public class ViewTeam extends BaseObservable {
    private Team team;

    public ViewTeam(Context context, Team team) {
        Context context1 = context;
        this.team = team;
    }

    @Bindable
    public String getIdLeague() {
        return team.getIdLeague();
    }

    @Bindable
    public String getIdTeam() {
        return team.getIdTeam();
    }

    @Bindable
    public String getStrCountry() {
        return team.getStrCountry();
    }

    @Bindable
    public String getStrDescriptionEN() {
        return team.getStrDescriptionEN();
    }

    @Bindable
    public String getStrStadium() {
        return team.getStrStadium();
    }

    @Bindable
    public String getStrStadiumDescription() {
        return team.getStrStadiumDescription();
    }

    @Bindable
    public String getStrStadiumLocation() {
        return team.getStrStadiumLocation();
    }

    @Bindable
    public String getStrStadiumThumb() {
        return team.getStrStadiumThumb();
    }

    @BindingAdapter({"fanart"})
    public static void loadfanart(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop()
                .into(view);
    }

    @Bindable
    public String getStrTeam() {
        return team.getStrTeam();
    }

    @Bindable
    public String getStrTeamBadge() {
        return team.getStrTeamBadge();
    }

    @Bindable
    public String getStrTeamBanner() {
        return team.getStrTeamBanner();
    }

    @Bindable
    public String getStrTeamJersey() {
        return team.getStrTeamJersey();
    }

    @Bindable
    public String getStrTeamLogo() {
        return team.getStrTeamLogo();
    }

    @BindingAdapter({"teamlogo"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop()
                .into(view);
    }

    @Bindable
    public String getStrManager() {
        return team.getStrManager();
    }
}
