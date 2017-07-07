package com.bignerdranch.android.enterpriseshow.model;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6/006.
 */

public class MyItem {

    /**
     * code : 1
     * msg : success
     * data : [{"createTime":"2016-12-15 14:19:57","id":2,"image":"http://img01.weishangagent.com/img/A/YMXXXX306375-121720_YM0000.jpg","isDelete":0,"isUpdate":1,"modifyTime":"2016-12-15 14:19:57","name":"企业秀默认模板","preUrl":"st_res/default_qiyexiu/index.html","unquieName":"default_qiyexiu"},{"createTime":"2017-01-13 16:10:16","id":4,"image":"http://img01.weishangagent.com/img/A/YMXXXX306374-118297_YM0000.jpg","isDelete":0,"isUpdate":1,"modifyTime":"2017-01-13 16:10:16","name":"婚纱模板-黑金","preUrl":"st_res/qiyexiu-moban1/index.html","unquieName":"qiyexiu-moban1"},{"createTime":"2017-02-21 13:45:13","id":5,"isDelete":0,"isUpdate":1,"modifyTime":"2017-02-21 13:45:13","name":"科技版","preUrl":"st_res/kejiban/index.html","unquieName":"kejiban"},{"createTime":"2017-02-22 11:33:23","id":6,"image":"http://img01.weishangagent.com/img/A/YMXXXX315847-75897_YM0000.jpg","isDelete":0,"isUpdate":1,"modifyTime":"2017-02-22 11:33:23","name":"木林森模板","preUrl":"st_res/mulinsen/index.html","unquieName":"mulinsen"},{"createTime":"2017-03-22 09:27:07","id":7,"isDelete":0,"isUpdate":1,"modifyTime":"2017-03-22 09:27:07","name":"模板7","preUrl":"st_res/qiyexiu-moban7/index.html","unquieName":"qiyexiu-moban7"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 2016-12-15 14:19:57
         * id : 2
         * image : http://img01.weishangagent.com/img/A/YMXXXX306375-121720_YM0000.jpg
         * isDelete : 0
         * isUpdate : 1
         * modifyTime : 2016-12-15 14:19:57
         * name : 企业秀默认模板
         * preUrl : st_res/default_qiyexiu/index.html
         * unquieName : default_qiyexiu
         */

        private int id;
        private String image;
        private String name;
        private String preUrl;

        public String getPreUrl() {
            return preUrl;
        }

        public void setPreUrl(String preUrl) {
            this.preUrl = preUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
