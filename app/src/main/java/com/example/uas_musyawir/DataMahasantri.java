package com.example.uas_musyawir;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataMahasantri implements Serializable {

    @Expose
    @SerializedName("id") String id;

    @Expose
    @SerializedName("nama") String nama;

    @Expose
    @SerializedName("kelas") String kelas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}

