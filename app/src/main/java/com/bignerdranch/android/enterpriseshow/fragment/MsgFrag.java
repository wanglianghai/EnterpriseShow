package com.bignerdranch.android.enterpriseshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.LoginActivity;

import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/3/003.
 */

public class MsgFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_msg, container, false);
        return view;
    }

    @OnClick({R.id.user_button})
    void onClick() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
