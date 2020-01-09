package com.example.myapplicationteams.model.data.rom;

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

//    @Query("SELECT * FROM teamsdb WHERE team_id = :userId")
//    List<TeamDao> getUser(String userId);

    @Query("SELECT * FROM teamsdb")
    List<FeaturesDB> getUser();

//    @Query("DELETE FROM users WHERE user_name = :userId")
//    void deleteCheckTypes(int userId);


}
