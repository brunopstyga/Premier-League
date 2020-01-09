package com.example.myapplicationteams.model.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("strStadiumLocation")
    @Expose
    private String stadiumLocation;

    @SerializedName("strTeam")
    @Expose
    private String nameTeam;

    @SerializedName("intFormedYear")
    @Expose
    private int dateBirth;

    @SerializedName("strStadium")
    @Expose
    private String nameStadium;

    @SerializedName("strWebsite")
    @Expose
    private String strWebsite;

    @SerializedName("intStadiumCapacity")
    @Expose
    private int stadiumCapacity;

    @SerializedName("strStadiumDescription")
    @Expose
    private String strStadiumDescription;

    @SerializedName("strStadiumThumb")
    @Expose
    private String strStadiumThumb;

    @SerializedName("idTeam")
    @Expose
    private int idTeam;


    public Team(String stadiumLocation, String nameTeam, int dateBirth, String nameStadium, String strWebsite, int stadiumCapacity, String strStadiumDescription, String strStadiumThumb, int idTeam) {
        this.stadiumLocation = stadiumLocation;
        this.nameTeam = nameTeam;
        this.dateBirth = dateBirth;
        this.nameStadium = nameStadium;
        this.strWebsite = strWebsite;
        this.stadiumCapacity = stadiumCapacity;
        this.strStadiumDescription = strStadiumDescription;
        this.strStadiumThumb = strStadiumThumb;
        this.idTeam = idTeam;
    }


    public String getStadiumLocation() {
        return stadiumLocation;
    }

    public void setStadiumLocation(String stadiumLocation) {
        this.stadiumLocation = stadiumLocation;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNameStadium() {
        return nameStadium;
    }

    public void setNameStadium(String nameStadium) {
        this.nameStadium = nameStadium;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }
}
