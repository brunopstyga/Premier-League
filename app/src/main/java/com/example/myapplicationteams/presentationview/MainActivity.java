package com.example.myapplicationteams.presentationview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplicationnuevo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.buttontwo)
    Button btn;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager =  getSupportFragmentManager();


    }

    @OnClick(R.id.buttontwo)
    public void onClick() {
        try {
        Intent i = new Intent(this, TeamsActivity.class);
        startActivity(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
