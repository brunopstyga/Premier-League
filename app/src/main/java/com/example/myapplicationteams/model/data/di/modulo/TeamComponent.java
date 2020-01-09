package com.example.myapplicationteams.model.data.di.modulo;

import android.app.Application;


import com.example.myapplicationteams.model.data.di.modulo.factory.ViewModelModule;
import com.example.myapplicationteams.model.data.di.modulo.room.AppModule;
import com.example.myapplicationteams.model.data.di.modulo.room.RoomModule;
import com.example.myapplicationteams.model.data.rom.TeamDao;
import com.example.myapplicationteams.model.data.rom.TeamRoomDataBase;
import com.example.myapplicationteams.presentationview.TeamActivityFragment;
import com.example.myapplicationteams.presentationview.TeamsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        TeamModule.class,
        ViewModelModule.class,
        RoomModule.class
})
public interface TeamComponent {

    void inject (TeamsActivity teamsActivity);

    void inject (TeamActivityFragment teamActivityFragment);

//    Application application();
//
//    TeamDao getDao();
//
//    TeamRoomDataBase getTeamRoomDataBase();
}
