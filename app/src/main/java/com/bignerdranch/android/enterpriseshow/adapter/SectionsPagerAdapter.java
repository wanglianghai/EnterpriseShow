package com.bignerdranch.android.enterpriseshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

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
    private SparseArray<Fragment> mFragmentSparseArray;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentSparseArray = new SparseArray<>(3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return inSparseArray(new HomeFrag(), 0);
            case 1:
                return inSparseArray(new MsgFrag(), 1);
            case 2:
                return inSparseArray(new MineFrag(), 2);
        }
        return null;
    }

    private Fragment inSparseArray(Fragment f, int key) {
        mFragmentSparseArray.put(key, f);
        return f;
    }

    public Fragment getSparseArray(int key) {
        return mFragmentSparseArray.get(key);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
