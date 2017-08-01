package com.bignerdranch.android.enterpriseshow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bignerdranch.android.enterpriseshow.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login_register);
        ButterKnife.bind(this);
    }

}
