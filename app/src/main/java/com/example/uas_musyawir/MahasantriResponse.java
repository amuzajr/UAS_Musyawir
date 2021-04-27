package com.example.uas_musyawir;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MahasantriResponse {

    @Expose
    @SerializedName("data")
    ArrayList<DataMahasantri> dataMahasantri;

    public ArrayList<DataMahasantri> getDataMahasantri() {
        return dataMahasantri;
    }

    public void setDataMahasantri(ArrayList<DataMahasantri> dataMahasantri) {
        this.dataMahasantri = dataMahasantri;
    }
}
