package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/7/22/022.
 */

public class ImageBean {
    private String imagePath;
    private boolean selected = false;

    public ImageBean(){}

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

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
