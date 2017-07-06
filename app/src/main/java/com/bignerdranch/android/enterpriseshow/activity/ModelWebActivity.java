package com.bignerdranch.android.enterpriseshow.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ModelWebActivity extends AppCompatActivity {
    @Bind(R.id.model_relative)
    RelativeLayout modelRelative;
    @Bind(R.id.web_view)
    TextView mTextView;

    private String mString;
    private CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_web);
        int times = 2000;
        ButterKnife.bind(this);
        modelRelative.setVisibility(View.GONE);

        mString = getIntent().getStringExtra("modelString");
        mTextView.setText(mString);
        mTextView.setClickable(true);
        timer = new CountDownTimer(times, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                modelRelative.setVisibility(View.GONE);
                timer.cancel();
            }
        };

        mTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
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

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("ModelWebActivity");
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("ModelWebActivity");
        MobclickAgent.onPause(this);
    }

}
