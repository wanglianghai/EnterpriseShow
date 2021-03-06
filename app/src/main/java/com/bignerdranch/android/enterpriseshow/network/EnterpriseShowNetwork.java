package com.bignerdranch.android.enterpriseshow.network;

import com.bignerdranch.android.enterpriseshow.network.api.EnterpriseShowApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/6/006.
 */

public class EnterpriseShowNetwork {
    public static final String preUrl = "preUrl";
    public static final String BASE_URL = "http://192.168.1.252:8088/";
    public static final String baseUrl = "http://192.168.1.252:8088/qiyexiu/";
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static RxJava2CallAdapterFactory sRxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static GsonConverterFactory gsonConvertFactory = GsonConverterFactory.create();
    private static EnterpriseShowApi sMyApi;


    //客户端
    public static EnterpriseShowApi myApi() {
        if (sMyApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(sRxJavaCallAdapterFactory)
                    .addConverterFactory(gsonConvertFactory)
                    .build();

            sMyApi = retrofit.create(EnterpriseShowApi.class);
        }

        return sMyApi;
    }
}
