package com.bignerdranch.android.enterpriseshow.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SiteDetailAdapter;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.bean.ImageLibrary;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/4/004.
 */

public class SiteDetailActivity extends AppCompatActivity {
    @Bind(R.id.header_title) TextView headerTitle;
    @Bind(R.id.header_right) TextView headerRight;
    @Bind(R.id.site_detail_recycler) RecyclerView mDetailRecycler;

    private static final String TAG = "SiteDetailActivity";
    public static final int UPDATE = 0;

    private SiteDetailAdapter mAdapter;

    private List<ImageBean> mImageBeen;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_site_detail);
        ButterKnife.bind(this);

        mImageBeen = new ArrayList<>();
        mImageBeen.add(null);

        mAdapter = new SiteDetailAdapter(this, mImageBeen);
        mDetailRecycler.setAdapter(mAdapter);
        mDetailRecycler.setLayoutManager(new GridLayoutManager(this, 4));

        headerTitle.setText("编辑企业基本信息");
        headerRight.setText("保存");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case UPDATE:
                mImageBeen.clear();
                mImageBeen.add(null);
                for (ImageBean bean: ImageLibrary.get().getImageBeen()) {
                    mImageBeen.add(bean);
                    Log.i(TAG, "onActivityResult: " + bean.getImagePath());
                }
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    @OnClick({R.id.header_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_back:
                finish();
                break;
        }
    }

    public void startActivity() {
        Intent intent = new Intent(this, SiteDetailImgAc.class);
        startActivityForResult(intent, UPDATE);
    }
}
