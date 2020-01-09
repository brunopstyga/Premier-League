package com.example.myapplicationteams.presentationview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplicationnuevo.R;
import com.example.myapplicationteams.model.data.MessageEvent;
import com.example.myapplicationteams.model.data.di.modulo.TeamApplication;
import com.example.myapplicationteams.model.data.rom.FeaturesDB;
import com.example.myapplicationteams.model.data.rom.TeamRoomDataBase;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TeamActivityFragment extends Fragment {

    @Inject
    TeamRoomDataBase TeamRoomDataBase;

    private FragmentManager fragmentManager;

    private int umberSelected = 0;

    private List<FeaturesDB> teamdb = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_feature, container, false);
        fragmentManager =  getFragmentManager();
        TeamActivityFragment teamActivityFragment = (TeamActivityFragment)fragmentManager.findFragmentByTag("TeamFragment");
        Bundle bundle = teamActivityFragment.getArguments();
        if (bundle != null) {
            umberSelected = bundle.getInt(Util.FROMADAPTERTEAM, -1);

            teamdb = TeamRoomDataBase.teamDao().getUser();


//    imageview.setImageURI(Uri.parse(imageBaseDirectory+imageName));

        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        // ((TeamApplication) getApplication()).getRetrofitComponent().inject(this);
//        ((TeamActivityFragment)context.getApplicationContext()).getActivity().getRetrofitComponent().inject(this);
        super.onAttach(context);
    }

    //    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent event){
//        try {
//
//            umberSelected = event.getNumberselected();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }


}
