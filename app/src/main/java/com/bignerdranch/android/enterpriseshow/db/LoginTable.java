package com.bignerdranch.android.enterpriseshow.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/8/3/003.
 */

public class LoginTable extends DataSupport {
    private String username;
    private String password;

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
