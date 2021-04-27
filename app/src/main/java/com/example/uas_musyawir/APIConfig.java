package com.example.uas_musyawir;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConfig {
    static String baseUrl = "http://192.168.43.56/JSon/UAS/show.php";

    public static Retrofit loadData(){
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(request);

            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public Call<MahasantriResponse> postData() {
        return null;
    }
}
