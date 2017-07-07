package com.bignerdranch.android.enterpriseshow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.network.MyNetwork;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModelWebActivity extends AppCompatActivity {
    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.model_relative)
    RelativeLayout modelRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_web);
        ButterKnife.bind(this);

        webView.setClickable(true);

        setModelRelativeShow();

        //打开网页
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getIntent().getStringExtra(MyNetwork.preUrl));
    }

    @OnClick({R.id.back, R.id.user_model})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.user_model:
                startActivity(new Intent(this, SiteDetailActivity.class));
                break;
        }
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
