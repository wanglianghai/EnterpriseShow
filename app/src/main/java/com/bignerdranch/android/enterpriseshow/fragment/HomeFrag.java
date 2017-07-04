package com.bignerdranch.android.enterpriseshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.MySiteActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteStatisticsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/3/003.
 */

public class HomeFrag extends Fragment {
    private static final String TAG = "HomeFrag";
    public static HomeFrag fragment;
    private AppCompatActivity activity;

    private View rootView;

    public static HomeFrag newInstance() {
        if (fragment == null) {
            fragment = new HomeFrag();
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (AppCompatActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.frag_home, container, false);
            ButterKnife.bind(this, rootView);
        }

        return rootView;
    }

    @OnClick({R.id.check_detail, R.id.my_show, R.id.add_show_linear})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_detail:
                Log.i(TAG, "onClick: " + "0");
                startActivity(new Intent(activity, SiteStatisticsActivity.class));
                break;
            case R.id.my_show:
                startActivity(new Intent(activity, MySiteActivity.class));
                break;
            case R.id.add_show_linear:
                startActivity(new Intent(activity, SiteDetailActivity.class));
                break;
        }
    }

}
