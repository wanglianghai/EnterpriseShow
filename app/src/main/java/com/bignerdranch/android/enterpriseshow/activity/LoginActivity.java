package com.bignerdranch.android.enterpriseshow.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bignerdranch.android.enterpriseshow.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register})
    void onClick() {
        startActivity(new Intent(LoginActivity.this, LoginRegisterActivity.class));
    }
}
