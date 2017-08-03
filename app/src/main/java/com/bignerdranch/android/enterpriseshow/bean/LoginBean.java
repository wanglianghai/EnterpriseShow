package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/8/2/002.
 */

public class LoginBean {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"id":7,"sessionId":"14FBC991295236F1DBDF267BA5D9F6C6","userName":"18267008702"}
     *                             14FBC991295236F1DBDF267BA5D9F6C6
     */

    private String code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 7
         * sessionId : 14FBC991295236F1DBDF267BA5D9F6C6
         * userName : 18267008702
         */

        private int id;
        private String sessionId;
        private String userName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
