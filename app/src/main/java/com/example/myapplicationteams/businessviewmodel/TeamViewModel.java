package com.example.myapplicationteams.businessviewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplicationteams.Base.BaseViewModel;
import com.example.myapplicationteams.model.data.entity.Team;
import com.example.myapplicationteams.model.data.entity.TeamResponse;
import com.example.myapplicationteams.model.data.manager.WebServiceClient;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamViewModel extends BaseViewModel {

    private final String ID_value = "4328";
    MutableLiveData<List<Team>> data = new MutableLiveData<>();

    WebServiceClient client;

    @Inject
    public TeamViewModel(WebServiceClient webServiceClient) {
        client = webServiceClient;
    }

    @Override
    public void fetchListTeam() {
        Call<TeamResponse> call = client.getListTeam(ID_value);
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                Log.d("TGI", "ERROR:" + response.message());
                data.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.d("TGI", "ERROR:" + t.getMessage());
            }
        });
    }

    public MutableLiveData<List<Team>> getTeamResponseMutableLiveData() {
        fetchListTeam();
        return data;
    }

}
