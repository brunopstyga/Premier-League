package com.example.myapplicationteams.model.data.di.modulo.room;

import com.example.myapplicationteams.model.data.rom.FeaturesDB;
import com.example.myapplicationteams.model.data.rom.TeamDao;

import java.util.Collection;
import java.util.List;

public class TeamDataSource implements RoomRepository {

    private TeamDao teamDao;

    public TeamDataSource (TeamDao teamDao){
        this.teamDao = teamDao;
    }


    @Override
    public List<FeaturesDB> findAll() {
        return teamDao.getListCharactTeams();
    }

    @Override
    public long[] insert(Collection<FeaturesDB> team) {
        return teamDao.addUser(team);
    }


    @Override
    public int delete(FeaturesDB product) {
        return 0;
    }
}
