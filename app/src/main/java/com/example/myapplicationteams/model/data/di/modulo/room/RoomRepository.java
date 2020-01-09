package com.example.myapplicationteams.model.data.di.modulo.room;

import androidx.lifecycle.LiveData;

import com.example.myapplicationteams.model.data.rom.FeaturesDB;

import java.util.Collection;
import java.util.List;

public interface RoomRepository {

    List<FeaturesDB> findAll();

    long[] insert(Collection<FeaturesDB> team);

    int delete(FeaturesDB product);

}
