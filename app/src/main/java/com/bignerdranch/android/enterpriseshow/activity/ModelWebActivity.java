package com.bignerdranch.android.enterpriseshow.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ModelWebActivity extends AppCompatActivity {
    @Bind(R.id.web_view)
    TextView webView;
    @Bind(R.id.model_relative)
    RelativeLayout modelRelative;

    private String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_web);
        ButterKnife.bind(this);
        mString = getIntent().getStringExtra("modelString");
        webView.setText(mString);
        webView.setClickable(true);

        setModelRelativeShow();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    private void setModelRelativeShow() {
        modelRelative.setVisibility(View.GONE);
        final CountDownTimer timer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                modelRelative.setVisibility(View.GONE);
            }
        };
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        timer.start();
                        break;
                    case MotionEvent.ACTION_DOWN:
                        modelRelative.setVisibility(View.VISIBLE);
                        timer.cancel();
                        break;
                }
                return false;
            }
        });
    }
}