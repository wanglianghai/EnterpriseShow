package com.bignerdranch.android.enterpriseshow.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/4/004.
 */

public class SiteDetailActivity extends AppCompatActivity {
    @Bind(R.id.header_title)
    TextView headerTitle;
    @Bind(R.id.header_right)
    TextView headerRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_site_detail);
        ButterKnife.bind(this);

        headerTitle.setText("编辑企业基本信息");
        headerRight.setText("保存");
    }

    @OnClick({R.id.header_back})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_back:
                finish();
                break;
        }
    }
}
