package com.example.myapplicationteams.presentationview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationnuevo.R;
import com.example.myapplicationteams.businessviewmodel.TeamViewModel;
import com.example.myapplicationteams.model.data.entity.Team;
import com.example.myapplicationteams.model.data.di.modulo.TeamApplication;
import com.example.myapplicationteams.model.data.di.modulo.factory.ViewModelFactory;
import com.example.myapplicationteams.model.data.rom.FeaturesDB;
import com.example.myapplicationteams.model.data.rom.TeamRoomDataBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static java.util.stream.Collectors.toCollection;

public class TeamsActivity extends AppCompatActivity {

    private CustomAdapterInfoTeam customAdapterInfoTeam;
    private TeamViewModel teamViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    @Inject
    TeamRoomDataBase TeamRoomDataBase;


    private RecyclerView recyclerView;
    private List<Team> teams = new ArrayList<>();
    private FragmentManager fragmentManager;
    private int i = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((TeamApplication) getApplication()).getRetrofitComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitle(R.string.app_name);
        fragmentManager =  getSupportFragmentManager();
        setUpView();
        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel.class);
        teamViewModel.getTeamResponseMutableLiveData().observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(List<Team> teams) {
                customAdapterInfoTeam.setData(teams);
                TeamRoomDataBase.teamDao().addUser(reachData(teams));
            }
        });
    }

    public void setUpView() {
        recyclerView = findViewById(R.id.customRecyclerView);
        customAdapterInfoTeam = new CustomAdapterInfoTeam(fragmentManager,this, teams);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TeamsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapterInfoTeam);
    }

    public List<FeaturesDB> reachData(List<Team> teams) {
        List<FeaturesDB> test = teams.stream()
                .map(team -> {
                            return new FeaturesDB(++i, team.getStrStadiumThumb(), team.getStrStadiumDescription());
                        }
                ).collect(toCollection(ArrayList::new));
        return test;
    }

}
