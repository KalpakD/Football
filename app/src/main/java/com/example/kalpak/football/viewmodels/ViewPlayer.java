package com.example.kalpak.football.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kalpak.football.models.Player;

public class ViewPlayer extends BaseObservable {
    private Player player;

    public ViewPlayer(Context context, Player player) {
        Context context1 = context;
        this.player = player;
    }

    @Bindable
    public String getIdPlayer() {
        return player.getIdPlayer();
    }

    @Bindable
    public String getStrNationality() {
        return player.getStrNationality();
    }

    @Bindable
    public String getStrPlayer() {
        return player.getStrPlayer();
    }

    @Bindable
    public String getStrTeam() {
        return player.getStrTeam();
    }

    @Bindable
    public String getDateBorn() {
        return player.getDateBorn();
    }

    @Bindable
    public String getStrDescriptionEN() {
        return player.getStrDescriptionEN();
    }

    @Bindable
    public String getStrPosition() {
        return player.getStrPosition();
    }

    @Bindable
    public String getStrThumb() {
        return player.getStrThumb();
    }

    @Bindable
    public String getStrCutout() {
        return player.getStrCutout();
    }

    @BindingAdapter({"playercutout"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url).centerCrop()
                .into(view);
    }

    @Bindable
    public String getStrFanart1() {
        return player.getStrFanart1();
    }

}
