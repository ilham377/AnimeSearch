package com.iapps.animesearch.network;

import com.iapps.animesearch.model.jikan.JikanResult;
import com.iapps.animesearch.model.trace.TraceResult;
import com.iapps.animesearch.model.trace.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v3/anime/{id}")
    Call<JikanResult> getJikanResult(
            @Path("id") Integer id
    );

    @GET("search")
    Call<example> getexample(
            @Query("url") String url
    );


}
