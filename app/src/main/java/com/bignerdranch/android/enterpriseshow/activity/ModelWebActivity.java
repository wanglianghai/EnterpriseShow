package com.bignerdranch.android.enterpriseshow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ModelWebActivity extends AppCompatActivity {
    @Bind(R.id.model_relative)
    RelativeLayout modelRelative;
    @Bind(R.id.web_view)
    TextView mTextView;

    private String mString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_web);
        ButterKnife.bind(this);
        modelRelative.setVisibility(View.GONE);

        mString = getIntent().getStringExtra("modelString");
        mTextView.setText(mString);
    }
}
