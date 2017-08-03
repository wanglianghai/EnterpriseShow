package com.bignerdranch.android.enterpriseshow.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/8/3/003.
 */

public class ShowTable extends DataSupport {
    private int lastId;

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }
}
