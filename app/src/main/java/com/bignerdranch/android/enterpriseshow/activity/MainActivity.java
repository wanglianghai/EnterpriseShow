package com.bignerdranch.android.enterpriseshow.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.fragment.HomeFragment;
import com.bignerdranch.android.enterpriseshow.fragment.MessageFragment;
import com.bignerdranch.android.enterpriseshow.fragment.MineFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new MessageFragment();
                    case 2:
                        return new MineFragment();
                }
                return new HomeFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
