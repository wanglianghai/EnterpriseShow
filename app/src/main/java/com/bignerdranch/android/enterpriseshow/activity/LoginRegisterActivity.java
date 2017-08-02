package com.bignerdranch.android.enterpriseshow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.bean.UserCaptchaBean;
import com.bignerdranch.android.enterpriseshow.network.EnterpriseShowNetwork;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginRegisterActivity extends AppCompatActivity {
    @Bind(R.id.phone_number)
    EditText mUsernameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.exit)
    void onClickExit() {
        finish();
    }

    @OnClick({R.id.captcha})
    void onClick() {
        String userName = mUsernameET.getText().toString();
        if (userName.length() == 0) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        //^1\d{10}$ 匹配1开头的11个数字,^字符串的头，d数字，{10}$11个字符串
        if (!userName.matches("^1\\d{10}$")) {
            Toast.makeText(this, "手机号码错误", Toast.LENGTH_SHORT).show();
            return;
        }
        // Observable上游水管
        // subscribeOn 上游处理的地方
        // subscribe 连接管道连接上下游
        // ObserveOn 下游处理的地方
        // Observer 下游水管
        EnterpriseShowNetwork.myApi().captcha(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserCaptchaBean>() {
                    @Override
                    public void accept(UserCaptchaBean userCaptchaBean) throws Exception {
                        Toast.makeText(LoginRegisterActivity.this, userCaptchaBean.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
