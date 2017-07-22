package com.bignerdranch.android.enterpriseshow.uri;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/22/022.
 */
//file provider的uri
public class UriUtil {
    private static final String AUTHORITIES = "com.bignerdranch.android.enterpriseshow";
    private static Uri photoFileUri;
    private static String photoFileString;

    public static void setPhotoFileUri(Context context) {
        //得到输出的文件路径
        File dirFile = context.getFilesDir();
        //设置输出路径下存放的路径。（拼接string类型的加。.toString(),类型一致）
        String photoPathString = "IMG_" + UUID.randomUUID().toString() + ".jpg";
        File photoFile = new File(dirFile, photoPathString);
        photoFileString = photoFile.toString();
        //用输出路径配置file provider公共的uri
        photoFileUri = FileProvider.getUriForFile(context, AUTHORITIES, photoFile);
    }

    public static Uri getPhotoFileUri() {
        return photoFileUri;
    }

    public static String getPhotoFileString() {
        return photoFileString;
    }
}
