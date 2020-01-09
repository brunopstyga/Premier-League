package com.example.myapplicationteams.presentationview;

class FeatureTeams {

    private String stadiumCapacity;
    private String nameStadium;

    public FeatureTeams(String stadiumCapacity, String nameStadium) {
        this.stadiumCapacity = stadiumCapacity;
        this.nameStadium = nameStadium;
    }

    @Override
    public String toString() {
        return "FeatureTeams{" +
                "stadiumCapacity=" + stadiumCapacity +
                ", nameStadium='" + nameStadium + '\'' +
                '}';
    }
}
