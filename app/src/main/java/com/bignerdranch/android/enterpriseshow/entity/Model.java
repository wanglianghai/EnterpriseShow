package com.bignerdranch.android.enterpriseshow.entity;

/**
 * Created by Administrator on 2017/7/5/005.
 */

public class Model {
    private String mString;

    public Model(String s) {
        mString = s;
    }

    public String getString() {
        return mString;
    }

    public Model(){}

    Long id;
    String preUrl;// 静态链接

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreUrl() {
        return preUrl;
    }

    public void setPreUrl(String preUrl) {
        this.preUrl = preUrl;
    }
}
