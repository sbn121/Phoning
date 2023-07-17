package com.example.lastcloneappproject.common;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST
    Call<String> postLogin(@Url String url, @FieldMap HashMap<String, Object> paramMap);

    @GET("{login}")
    Call<String> getLogin(@Path("login") String mapping, @FieldMap HashMap<String, Object> paramMap);



}
