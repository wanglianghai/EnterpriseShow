package com.bignerdranch.android.enterpriseshow.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.bignerdranch.android.enterpriseshow.R;

//静态成员可以直接赋值？不能，在main activity中继承，用super调用父类方法
public class BaseActivity extends AppCompatActivity {
    //计算出屏幕的宽和高Pixels
    public static int W;
    public static int H;
    public static Context context;
    private static DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        metrics = context.getResources().getDisplayMetrics();
        W = metrics.widthPixels;
        H = metrics.heightPixels;
    }
}
