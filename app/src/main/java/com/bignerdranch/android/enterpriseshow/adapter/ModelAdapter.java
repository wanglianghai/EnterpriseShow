package com.bignerdranch.android.enterpriseshow.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.entity.Model;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5/005.
 */

public class ModelAdapter extends BaseQuickAdapter<Model>{
    //宽度的 1/3
    private int sizeW= BaseActivity.W / 3;

    //宽度的 1/3少留些白色背景   屏幕显示1080P
    private int sizeY = (int) (BaseActivity.W - 40f * (BaseActivity.W / 1080f)) / 3;

    public ModelAdapter(List<Model> data) {
        super(R.layout.item_model, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Model model) {
        final ImageView image = baseViewHolder.getView(R.id.model_image);
        Glide.with(mContext).load(R.drawable.model_detail_ico).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                //得到定义视图的属性重新设置
                ViewGroup.LayoutParams para = image.getLayoutParams();
                //图片长宽比例 从正方形变成长方形
                para.height = (int) (sizeY * (Float.valueOf(resource.getHeight()) / Float.valueOf(resource.getWidth())));
                para.width = sizeW;
                image.setLayoutParams(para);
                image.setImageBitmap(resource);
            }
        });
    }
}
