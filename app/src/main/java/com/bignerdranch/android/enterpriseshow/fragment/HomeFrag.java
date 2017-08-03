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
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.LoginActivity;
import com.bignerdranch.android.enterpriseshow.activity.ModelWebActivity;
import com.bignerdranch.android.enterpriseshow.activity.MySiteActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteStatisticsActivity;
import com.bignerdranch.android.enterpriseshow.adapter.ModelAdapter;

import com.bignerdranch.android.enterpriseshow.bean.BaseResultEntity;
import com.bignerdranch.android.enterpriseshow.bean.Statistics;
import com.bignerdranch.android.enterpriseshow.bean.User;
import com.bignerdranch.android.enterpriseshow.model.MyItem;
import com.bignerdranch.android.enterpriseshow.network.EnterpriseShowNetwork;
import com.bignerdranch.android.enterpriseshow.views.MyRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.reactivestreams.Subscription;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/3/003.
 */

public class HomeFrag extends Fragment {
    @Bind(R.id.model_list)
    MyRecyclerView modelList;
    @Bind(R.id.total_view)
    TextView mTVTotalView;
    @Bind(R.id.new_increase)
    TextView mTVNewIncrease;
    @Bind(R.id.leave_message)
    TextView mTVLeaveMessage;

    private Subscription mSubscription;
    private static final String TAG = "HomeFrag";
    private AppCompatActivity activity;
    private ModelAdapter adapter;

    private View rootView;
    private Observer<MyItem> mObserver = new Observer<MyItem>() {

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ", e);
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(MyItem myItem) {
            Log.i(TAG, "onNext: " + myItem.getData().size());
            adapter.setNewData(myItem.getData());
        }
    };

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
            if (adapter == null) {
                adapter = new ModelAdapter();
                search();
                modelList.setLayoutManager(new GridLayoutManager(activity, 3));
                modelList.setAdapter(adapter);
                modelList.addOnItemTouchListener(new OnItemClickListener() {
                    @Override
                    public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                        MyItem.DataBean model = (MyItem.DataBean) adapter.getItem(position);
                        Intent intent = new Intent(activity, ModelWebActivity.class);
                        intent.putExtra(EnterpriseShowNetwork.preUrl, EnterpriseShowNetwork.baseUrl + model.getPreUrl());
                        startActivity(intent);
                    }
                });
            }
        }

        showRecord();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        showRecord();
    }

    public void showRecord() {
        if (User.sUser != null) {
            Log.i("Control", "showRecord: ");
            EnterpriseShowNetwork.myApi().homeStatis(User.getUser().getId(), User.getUser().getSessionId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<BaseResultEntity<Statistics>>() {
                        @Override
                        public void accept(BaseResultEntity<Statistics> entity) throws Exception {
                            mTVTotalView.setText(entity.getData().getPageviews() + "");
                            mTVNewIncrease.setText(entity.getData().getTodayPageviews() + "");
                            mTVLeaveMessage.setText(entity.getData().getNewsNumber() + "");
                        }
                    });
        }
    }

    @OnClick({R.id.check_detail, R.id.my_show, R.id.add_show_linear})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_detail:
                if (User.sUser == null) {
                    startActivity(new Intent(activity, LoginActivity.class));
                } else {
                    startActivity(new Intent(activity, SiteStatisticsActivity.class));
                }
                break;
            case R.id.my_show:
                if (User.sUser == null) {
                    startActivity(new Intent(activity, LoginActivity.class));
                } else {
                    startActivity(new Intent(activity, MySiteActivity.class));
                }
                break;
            case R.id.add_show_linear:
                startActivity(new Intent(activity, SiteDetailActivity.class));
                break;
        }
    }

    private void search() {
        EnterpriseShowNetwork.myApi()
                .search()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unSubscription();
    }

    private void unSubscription() {
        if (mSubscription != null) {
            mSubscription = null;
        }
    }
}
