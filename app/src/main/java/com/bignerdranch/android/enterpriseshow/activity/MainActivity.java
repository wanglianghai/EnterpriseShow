package com.bignerdranch.android.enterpriseshow.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SectionsPagerAdapter;
import com.bignerdranch.android.enterpriseshow.views.MyViewPage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_home)
    TextView mHomeText;
    @Bind(R.id.main_mine)
    TextView mMineText;
    @Bind(R.id.main_msg)
    TextView mMsgText;
    @Bind(R.id.container)
    MyViewPage container;

    private List<TextView> mViews;

    private SectionsPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);

        addViews();

        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        container.setAdapter(adapter);
        addListener();

        mHomeText.setSelected(true);
    }

    @OnClick({R.id.main_home, R.id.main_msg, R.id.main_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                container.setCurrentItem(0);
                Log.i("onPageSelected", "onClick: 0");
                break;
            case R.id.main_msg:
                container.setCurrentItem(1);
                Log.i("onPageSelected", "onClick: 1");
                break;
            case R.id.main_mine:
                container.setCurrentItem(2);
                Log.i("onPageSelected", "onClick: 2");
                break;
        }
    }

    public void setCurrentBottom(int position) {
        for (int i = 0; i < mViews.size(); i ++) {
            if (i == position) {
                mViews.get(position).setSelected(true);
            } else {
                mViews.get(i).setSelected(false);
            }
        }
    }

    private void addViews() {
        mViews = new ArrayList<>();
        mViews.add(mHomeText);
        mViews.add(mMsgText);
        mViews.add(mMineText);
    }

    private void addListener() {
        container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurrentBottom(position);
                Log.i("MainActivity", "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
