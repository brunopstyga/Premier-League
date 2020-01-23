package com.example.myapplicationteams.model.data.room;

import java.util.Collection;

@SuppressWarnings("unchecked")
abstract public class DaoTeam implements TeamDao {
    @Override
    public long[] addUser(Collection<FeaturesDB> team) {
        return new long[0];
    }

    @Override
    public FeaturesDB getCharactTeamsId(int id) {
        return null;
    }


}
