package com.example.myapplicationteams.model.data.rom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FeaturesDB.class}, version = 1)
public abstract class TeamRoomDataBase extends RoomDatabase {

    public abstract TeamDao teamDao();

}
