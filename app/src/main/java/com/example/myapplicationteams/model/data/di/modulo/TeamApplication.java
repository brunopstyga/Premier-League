package com.example.myapplicationteams.model.data.di.modulo;

import android.app.Application;


import com.example.myapplicationteams.model.data.di.modulo.room.RoomModule;


public class TeamApplication extends Application {

    TeamComponent retrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitComponent = DaggerTeamComponent.builder()
                .teamModule(new TeamModule())
                .roomModule(new RoomModule(this))
                .build();

    }

    public TeamComponent getRetrofitComponent() {
        return retrofitComponent;
    }
}
