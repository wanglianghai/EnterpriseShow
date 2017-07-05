package com.bignerdranch.android.enterpriseshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.ModelWebActivity;
import com.bignerdranch.android.enterpriseshow.activity.MySiteActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteStatisticsActivity;
import com.bignerdranch.android.enterpriseshow.adapter.ModelAdapter;
import com.bignerdranch.android.enterpriseshow.entity.Model;
import com.bignerdranch.android.enterpriseshow.http.HttpManager;
import com.bignerdranch.android.enterpriseshow.views.MyRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/3/003.
 */

public class HomeFrag extends Fragment {
    @Bind(R.id.model_list)
    MyRecyclerView modelList;

    private static final String TAG = "HomeFrag";
    public static HomeFrag fragment;
    private AppCompatActivity activity;
    private ModelAdapter adapter;
    private List<Model> mArrayList;

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
        mArrayList = new ArrayList<>();
        mArrayList.add(new Model());
        mArrayList.add(new Model());
        mArrayList.add(new Model());
        mArrayList.add(new Model());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.frag_home, container, false);
            ButterKnife.bind(this, rootView);
            if (adapter == null) {
                adapter = new ModelAdapter(mArrayList);
                modelList.setLayoutManager(new GridLayoutManager(activity, 3));
                modelList.setAdapter(adapter);
                modelList.addOnItemTouchListener(new OnItemClickListener() {
                    @Override
                    public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        Model model = adapter.getItem(i);
                        Intent intent = new Intent(activity, ModelWebActivity.class);
                        intent.putExtra("webUrl",
                                HttpManager.BASE_URL + model.getPreUrl());
                        intent.putExtra("modelId", model.getId());
                        startActivity(intent);
                    }
                });
            }
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
