package com.bignerdranch.android.enterpriseshow.network.api;

import com.bignerdranch.android.enterpriseshow.bean.BaseResultEntity;
import com.bignerdranch.android.enterpriseshow.bean.LoginBean;
import com.bignerdranch.android.enterpriseshow.bean.Statistics;
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

    @FormUrlEncoded
    @POST("/qiyexiu/api/Login_login")
    Observable<LoginBean> login(@Field("userName") String userName, @Field("passWord") String passWord,
                                @Field("device") String device, @Field("deviceSysVersion") String deviceSysVersion,
                                @Field("channelId") String channelId, @Field("usePl") int usePl,
                                @Field("appVersion") String appVersion);

    @FormUrlEncoded
    @POST("/qiyexiu/api/SiteCount_findAllCount")
    Observable<BaseResultEntity<Statistics>> homeStatis(@Field("userId") Long userId, @Field("sessionId") String sessionId);

}
