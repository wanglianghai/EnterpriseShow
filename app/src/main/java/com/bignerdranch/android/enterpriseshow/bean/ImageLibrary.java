package com.bignerdranch.android.enterpriseshow.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/22/022.
 */

public class ImageLibrary {
    private static ImageLibrary sLibrary;
    private List<ImageBean> mImageBeen = new ArrayList<>();

    private ImageLibrary(){}

    public static ImageLibrary get() {
        if (sLibrary == null) {
            sLibrary = new ImageLibrary();
        }

        return sLibrary;
    }

    public List<ImageBean> getImageBeen() {
        return mImageBeen;
    }
}
