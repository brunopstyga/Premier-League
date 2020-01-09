package com.example.myapplicationteams.presentationview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationnuevo.R;

import java.util.List;

import com.example.myapplicationteams.model.data.MessageEvent;
import com.example.myapplicationteams.model.data.entity.Team;
import com.example.myapplicationteams.model.data.manager.MyListener;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAdapterInfoTeam extends RecyclerView.Adapter<CustomAdapterInfoTeam.CustomViewHolder> implements MyListener {

    private List<Team> dataList;
    private Context context;
    private FragmentManager fragmentManager;
    public int getPosition;


    public CustomAdapterInfoTeam(FragmentManager fragmentManager,Context context, List<Team> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void addTwoNumbers(int a) {

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

//        TextView locationstadium;


//        TextView name;
//        TextView website;
//        TextView Date;
//        TextView namestadium;
//        TextView stadiumcapacity;
        @BindView(R.id.textNamebutton)
        TextView name;
        @BindView(R.id.text_locationstadium)
        TextView locationstadium;
        @BindView(R.id.text_website)
        TextView website;
        @BindView(R.id.tex_datebirth)
        TextView Date;
        @BindView(R.id.text_namestadium)
        TextView namestadium;
        @BindView(R.id.tex_stadiumcapacity)
        TextView stadiumcapacity;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this, itemView);
//            name  = mView.findViewById(R.id.textNamebutton);
//            locationstadium = mView.findViewById(R.id.text_locationstadium);
//            website = mView.findViewById(R.id.text_website);
//            Date = mView.findViewById(R.id.tex_datebirth);
//            namestadium = mView.findViewById(R.id.text_namestadium);
//            stadiumcapacity = mView.findViewById(R.id.tex_stadiumcapacity);


        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_partial_info_team, parent, false);
        return new CustomViewHolder(view);
    }

    public void setData(List<Team> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        try {
            holder.locationstadium.setText(dataList.get(position).getStadiumLocation());
            holder.name.setText(dataList.get(position).getNameTeam());

            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        TeamActivityFragment featureFragment = new TeamActivityFragment();
                        Bundle bundle = new Bundle();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.fragment_main, featureFragment, "TeamFragment");
                        int position =  holder.getAdapterPosition();
                        bundle.putInt(Util.FROMADAPTERTEAM,position);
                        featureFragment.setArguments(bundle);
                        transaction.commit();
//                    Intent numbersIntent = new Intent(context, FeatureFragment.class);
//                    context.startActivity(numbersIntent);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            holder.Date.setText(String.valueOf(dataList.get(position).getDateBirth()));
            holder.namestadium.setText(dataList.get(position).getNameStadium());
            holder.website.setText(dataList.get(position).getStrWebsite());
            holder.stadiumcapacity.setText(String.valueOf(dataList.get(position).getStadiumCapacity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
