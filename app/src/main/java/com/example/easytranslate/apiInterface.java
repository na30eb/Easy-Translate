package com.example.easytranslate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiInterface {
    @GET("search")
    Call<List<modelClass>> getdata(
            @Query("token") String token
            , @Query("q") String q
            , @Query("type") String type
            ,@Query("filter") String filter);
}
