package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/8/2/002.
 */

public class BaseResultEntity<T> {
    //  判断标示
    private int code;
    //    提示信息
    private String msg;
    //显示数据（用户需要关心的数据）
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResultEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
