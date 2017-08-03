package com.bignerdranch.android.enterpriseshow.bean;

import android.net.Network;
import android.os.Build;

import com.bignerdranch.android.enterpriseshow.network.EnterpriseShowNetwork;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/2/002.
 */

public class Login {
    private String userName;        	 //用户名
    private String passWord;          	 //密码
    private String device = "Android";         	 //Android  Iphone
    private String deviceSysVersion = Build.VERSION.RELEASE;     //设备系统版本
    private String channelId = "";     	     //(根据 百度云，或者 其他的 平台参数获取)
    private Integer usePl = 1;               //1 百度云推送
    private String appVersion;          //当前app的版本号

    public Login(){}

    public Login(String userName, String passWord, String device, String deviceSysVersion,
                 String channelId, Integer usePl, String appVersion) {
        this.userName = userName;
        this.passWord = passWord;
        this.device = device;
        this.deviceSysVersion = deviceSysVersion;
        this.channelId = channelId;
        this.usePl = usePl;
        this.appVersion = appVersion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceSysVersion() {
        return deviceSysVersion;
    }

    public void setDeviceSysVersion(String deviceSysVersion) {
        this.deviceSysVersion = deviceSysVersion;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Integer getUsePl() {
        return usePl;
    }

    public void setUsePl(Integer usePl) {
        this.usePl = usePl;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Observable<LoginBean> getObservable() {
        return EnterpriseShowNetwork.myApi().login(userName, passWord, device, deviceSysVersion, channelId,
                usePl, appVersion);
    }
}
