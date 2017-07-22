package com.bignerdranch.android.enterpriseshow.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.bignerdranch.android.enterpriseshow.R;

//静态成员可以直接赋值？不能，在main activity中继承，用super调用父类方法
public class BaseActivity extends AppCompatActivity {
    //计算出屏幕的宽和高Pixels
    public static int W;
    public static int H;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //context通过获取屏幕宽度
        //1.从环境的系统服务中得到窗口的管理对象
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        //2.显示指标对象
        DisplayMetrics dm = new DisplayMetrics();
        //3.用窗口管理设置显示指标
        wm.getDefaultDisplay().getMetrics(dm);
        W = dm.widthPixels;
        H = dm.heightPixels;
    }
}
