package com.example.myapplicationteams.model.data.manager;

import com.example.myapplicationteams.model.data.entity.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceClient {

    @GET("/api/v1/json/1/lookup_all_teams.php")
    Call<TeamResponse> getListTeam(@Query("id")String id);
}
