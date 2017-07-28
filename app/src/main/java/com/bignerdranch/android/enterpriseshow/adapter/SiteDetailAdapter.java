package com.bignerdranch.android.enterpriseshow.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailImgAc;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.bean.ImageLibrary;
import com.bignerdranch.android.enterpriseshow.model.SiteDetailImg;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/21/021.
 */

public class SiteDetailAdapter extends ImageBaseAdapter {

    public SiteDetailAdapter(SiteDetailActivity context, List<ImageBean> imageBeen) {
        super(context, imageBeen);
    }


    @Override
    public int layoutRes() {
        return R.layout.ac_site_detail_item_img_d;
    }

}
