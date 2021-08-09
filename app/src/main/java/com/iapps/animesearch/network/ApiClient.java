package com.iapps.animesearch.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient apiClient;
    private Retrofit retrofit;

    private ApiClient() {
        final String BASE_URL = "https://api.jikan.moe/";

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public ApiClient(int i) {
        final String BASE_API_URL = "https://api.trace.moe/";

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(logging);

        httpclient.networkInterceptors();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclient.build())
                .build();
    }



    public static synchronized ApiClient getInstance() {
        apiClient = new ApiClient();
        return apiClient;
    }

    public static synchronized ApiClient getTraceInstance() {
        apiClient = new ApiClient(1);
        return apiClient;
    }



    public ApiService getAPIService() {
        return retrofit.create(ApiService.class);
    }



}


