package com.example.uas_musyawir;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("show.php")
    Call<MahasantriResponse> postData();
}
