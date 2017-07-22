package com.bignerdranch.android.enterpriseshow.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SiteDetailImgAdapter;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.bean.ImageLibrary;
import com.bignerdranch.android.enterpriseshow.uri.UriUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SiteDetailImgAc extends AppCompatActivity {
    private static final String TAG = "SiteDetailImgAc";
    public static final int REQUEST_PHOTO = 0;

    @Bind(R.id.img_recycler_view)
    RecyclerView mRecyclerView;

    private SiteDetailImgAdapter mImgAdapter;
    private List<ImageBean> mImageBeen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_detail_img);
        ButterKnife.bind(this);

        mImageBeen = new ArrayList<>();
        mImageBeen.add(null);
        mImgAdapter = new SiteDetailImgAdapter(this, mImageBeen);
        mRecyclerView.setAdapter(mImgAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case REQUEST_PHOTO:
                Log.i(TAG, "onActivityResult: photo");
                ImageBean image = new ImageBean(UriUtil.getPhotoFileString());
                ImageLibrary.get().getImageBeen().add(image);
                setResult(SiteDetailActivity.UPDATE);
                this.finish();
                break;
        }
    }
}
