package com.bignerdranch.android.enterpriseshow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SectionsPagerAdapter;
import com.bignerdranch.android.enterpriseshow.views.MyViewPage;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_home)
    TextView mHomeText;
    @Bind(R.id.main_mine)
    TextView mMineText;
    @Bind(R.id.main_msg)
    TextView mMsgText;
    @Bind(R.id.container)
    MyViewPage container;

    private View mSelectView;

    private SectionsPagerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);

        adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        container.setAdapter(adapter);
        mSelectView = mHomeText;
        mHomeText.setSelected(true);
    }

    @OnClick({R.id.main_home, R.id.main_msg, R.id.main_mine})
    public void onClick(View view) {
        mSelectView.setSelected(false);
        view.setSelected(true);
        mSelectView = view;
        switch (view.getId()) {
            case R.id.main_home:
                container.setCurrentItem(0);
                break;
            case R.id.main_msg:
                container.setCurrentItem(1);
                break;
            case R.id.main_mine:
                container.setCurrentItem(2);
                break;
        }
    }
}
