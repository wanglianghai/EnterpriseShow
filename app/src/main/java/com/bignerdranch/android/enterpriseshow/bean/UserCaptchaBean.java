package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/8/1/001.
 */

public class UserCaptchaBean {

    /**
     * code : 0
     * msg : 该号码已经注册过
     */

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
