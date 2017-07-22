package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/7/22/022.
 */

public class ImageBean {
    private String imagePath;

    public ImageBean(){}

    public ImageBean(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
