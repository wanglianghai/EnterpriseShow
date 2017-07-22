package com.bignerdranch.android.enterpriseshow.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailImgAc;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/22/022.
 */

public class SiteDetailImgAdapter extends ImageBaseAdapter {

    public SiteDetailImgAdapter(AppCompatActivity context, List<ImageBean> imageBeen) {
        super(context, imageBeen);
    }


}
