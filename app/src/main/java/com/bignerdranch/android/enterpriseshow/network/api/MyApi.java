package com.bignerdranch.android.enterpriseshow.network.api;

import com.bignerdranch.android.enterpriseshow.model.MyItem;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/7/6/006.
 */

public interface MyApi {
    @GET("Site_templateList")
    Observable<MyItem> search();
}
