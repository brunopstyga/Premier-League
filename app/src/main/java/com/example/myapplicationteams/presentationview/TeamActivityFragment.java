package com.example.myapplicationteams.presentationview;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.myapplicationnuevo.R;
import com.example.myapplicationteams.model.data.di.modulo.TeamApplication;
import com.example.myapplicationteams.model.data.manager.MyListener;
import com.example.myapplicationteams.model.data.rom.FeaturesDB;
import com.example.myapplicationteams.model.data.rom.TeamRoomDataBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamActivityFragment extends Fragment{

    @Inject
    TeamRoomDataBase TeamRoomDataBase;

    private FragmentManager fragmentManager;

    private int umberSelected = 0;

    private List<FeaturesDB> teamdb = new ArrayList<>();

    @BindView(R.id.textViewDescription)
    TextView texDes;

    @BindView(R.id.imageViewStadium)
    ImageView imageStadium;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_feature, container, false);
        ButterKnife.bind(this, view);
        try {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_action_name);
            toolbar.setTitle(R.string.app_name);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            });



        }catch (Exception e){
         e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentManager =  getFragmentManager();
        TeamActivityFragment teamActivityFragment = (TeamActivityFragment)fragmentManager.findFragmentByTag("TeamFragment");
        Bundle bundle = teamActivityFragment.getArguments();
        if (bundle != null) {
            umberSelected = bundle.getInt(Util.FROMADAPTERTEAM, -1);
            FeaturesDB  teamdba = TeamRoomDataBase.teamDao().getCharactTeamsId(umberSelected);
            texDes.setText(teamdba.getDescrip());
            final String URL =teamdba.getPhoto();
            Glide.with(getActivity())
                    .load(URL)
//                    .error(R.drawable.error);
//                    .placeholder(R.drawable.placeholder)
                    .into(imageStadium);

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        ((TeamApplication) getActivity().getApplication()).getRetrofitComponent().inject(this);
        super.onAttach(context);
    }


}
