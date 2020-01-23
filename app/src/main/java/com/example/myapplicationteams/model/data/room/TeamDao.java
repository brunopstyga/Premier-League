package com.example.myapplicationteams.model.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Collection;
import java.util.List;

@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[]addUser(Collection<FeaturesDB> team);

    @Query("SELECT * FROM teamsdb WHERE team_id = :id")
    FeaturesDB getCharactTeamsId(int id);

    @Query("SELECT * FROM teamsdb")
    List<FeaturesDB>getListCharactTeams();

//    @Query("DELETE FROM users WHERE user_name = :userId")
//    void deleteCheckTypes(int userId);


}
