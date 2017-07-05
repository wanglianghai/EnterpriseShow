package com.bignerdranch.android.enterpriseshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.activity.MainActivity;
import com.bignerdranch.android.enterpriseshow.fragment.HomeFrag;
import com.bignerdranch.android.enterpriseshow.fragment.MineFrag;
import com.bignerdranch.android.enterpriseshow.fragment.MsgFrag;

/**
 * Created by Administrator on 2017/7/4/004.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFrag.newInstance();
            case 1:
                return MsgFrag.newInstance();
            case 2:
                return MineFrag.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
