package com.example.myapplicationteams.model.data.di.modulo;


import com.example.myapplicationteams.model.data.di.modulo.factory.ViewModelModule;
import com.example.myapplicationteams.model.data.di.modulo.room.RoomModule;
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
}
