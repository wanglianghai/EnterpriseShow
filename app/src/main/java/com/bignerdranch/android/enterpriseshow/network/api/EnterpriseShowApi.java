package com.bignerdranch.android.enterpriseshow.network.api;

import com.bignerdranch.android.enterpriseshow.bean.UserCaptchaBean;
import com.bignerdranch.android.enterpriseshow.model.MyItem;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/7/6/006.
 */

public interface EnterpriseShowApi {
    @GET("/qiyexiu/api/Site_templateList")
    Observable<MyItem> search();

    @FormUrlEncoded
    @POST("/qiyexiu/api/Login_registCaptcha")
    Observable<UserCaptchaBean> captcha(@Field("userName") String userName);
}
