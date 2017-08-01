package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/8/1/001.
 */

public class User {
    public static User sUser;
    private String username;
    private String password;

    private User(){}

    public static User getUser() {
        if (sUser == null) {
            sUser = new User();
        }
        return sUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
