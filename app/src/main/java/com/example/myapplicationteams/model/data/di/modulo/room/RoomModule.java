package com.example.myapplicationteams.model.data.di.modulo.room;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplicationteams.model.data.room.TeamRoomDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private TeamRoomDataBase teamRoomDataBase;

    public RoomModule(Application mApplication) {
        teamRoomDataBase = Room.databaseBuilder(mApplication,TeamRoomDataBase.class,"features.db").allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    TeamRoomDataBase providesRoomDatabase() {
        return teamRoomDataBase;
    }






}
