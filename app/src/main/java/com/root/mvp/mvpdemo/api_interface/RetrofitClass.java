package com.root.mvp.mvpdemo.api_interface;

import com.root.mvp.mvpdemo.utils.ApplicationConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClass {


    public static Retrofit retrofit = new Retrofit.Builder().baseUrl(ApplicationConstant.BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).client(configureTimeouts())
            .build();

    public static OkHttpClient configureTimeouts() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
}
