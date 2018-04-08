package com.example.kalpak.football.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kalpak.football.models.League;

public class ViewLeague extends BaseObservable {

    Context context;
    League league;

    public ViewLeague(Context context, League league) {
        this.context = context;
        this.league = league;
    }
    @Bindable
    public String getIdLeague() {
        return league.getIdLeague();
    }
    @Bindable
    public String getStrCountry() {
        return league.getStrCountry();
    }
    @Bindable
    public String getStrDescriptionEN() {
        return league.getStrDescriptionEN();
    }
    @Bindable
    public String getStrBadge() {
        return league.getStrBadge();
    }
    @Bindable
    public String getStrLeague() {
        return league.getStrLeague();
    }
    @Bindable
    public String getStrLogo() {
        return league.getStrLogo();
    }
    @BindingAdapter({"logo"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop()
                .into(view);
    }
    @Bindable
    public String getStrTrophy() {
        return league.getStrTrophy();
    }
    @Bindable
    public String getStrFanart1() {
        return league.getStrFanart1();
    }
}
