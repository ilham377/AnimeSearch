package com.iapps.animesearch.network;

import com.iapps.animesearch.model.jikan.JikanResult;
import com.iapps.animesearch.model.trace.TraceResult;
import com.iapps.animesearch.model.trace.example;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface ApiService {

    @GET("v3/anime/{id}")
    Call<JikanResult> getJikanResult(
            @Path("id") Integer id
    );

    @GET("search")
    Call<example> getexample(
            @QueryName String anilistInfo,
            @Query("url") String url
    );

    @Multipart
    @POST("search")
    Call<example> upload(
            @QueryName String anilistInfo,
            @Part MultipartBody.Part file
    );



}
