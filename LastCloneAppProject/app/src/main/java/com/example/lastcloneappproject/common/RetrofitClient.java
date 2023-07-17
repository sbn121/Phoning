package com.example.lastcloneappproject.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    public Retrofit retrofitLogin(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.0.33:8080/middle/phoning/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
}
