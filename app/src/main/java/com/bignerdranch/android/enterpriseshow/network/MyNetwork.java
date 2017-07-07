package com.bignerdranch.android.enterpriseshow.network;

import com.bignerdranch.android.enterpriseshow.network.api.MyApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/6/006.
 */

public class MyNetwork {
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static CallAdapter.Factory sRxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static Converter.Factory gsonConvertFactory = GsonConverterFactory.create();
    private static MyApi sMyApi;

    public static MyApi myApi() {
        if (sMyApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl("http://192.168.1.252:8088/qiyexiu/api/")
                    .addCallAdapterFactory(sRxJavaCallAdapterFactory)
                    .addConverterFactory(gsonConvertFactory)
                    .build();

            sMyApi = retrofit.create(MyApi.class);
        }

        return sMyApi;
    }
}
