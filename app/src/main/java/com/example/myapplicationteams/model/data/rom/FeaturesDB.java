package com.example.myapplicationteams.model.data.rom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;


@Entity(tableName = "teamsdb")
public class FeaturesDB {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "team_id")
    private int id;

    @ColumnInfo (name = "stadium_photo")
    private String photo;

    @ColumnInfo (name = "description")
    private String descrip;

    public FeaturesDB(int id, String photo, String descrip) {
        this.id = id;
        this.photo = photo;
        this.descrip = descrip;
    }

    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
