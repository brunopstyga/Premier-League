package com.example.myapplicationteams.model.data.di.modulo.room;

import com.example.myapplicationteams.model.data.room.FeaturesDB;

import java.util.Collection;
import java.util.List;

public interface RoomRepository {

    List<FeaturesDB> findAll();

    long[] insert(Collection<FeaturesDB> team);

    int delete(FeaturesDB product);

}
