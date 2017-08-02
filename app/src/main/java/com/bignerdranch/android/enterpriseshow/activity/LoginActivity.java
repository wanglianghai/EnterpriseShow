package com.bignerdranch.android.enterpriseshow.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.bean.Login;
import com.bignerdranch.android.enterpriseshow.bean.LoginBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.user_name)
    EditText mETUserName;
    @Bind(R.id.pass_word)
    EditText mETPassWord;

    private Login mLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
        ButterKnife.bind(this);

        mLoginUser = new Login();
    }

    @OnClick(R.id.login)
    void onClickLogin() {
        String userName = mETUserName.getText().toString();
        if (userName.length() == 0) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userName.matches("^1\\d{10}$")) {
            Toast.makeText(this, "手机号码格式错误", Toast.LENGTH_SHORT).show();
            return;
        }

        String passWord = mETPassWord.getText().toString();
        if (6 > passWord.length() || passWord.length() > 12) {
            Toast.makeText(this, "请输入6~12位的密码", Toast.LENGTH_SHORT).show();
            return;
        }

        mLoginUser.setUserName(userName);
        mLoginUser.setPassWord(passWord);
        mLoginUser.setDevice("Android");
        mLoginUser.setDeviceSysVersion(Build.VERSION.RELEASE);
        mLoginUser.setChannelId("");
        mLoginUser.setUsePl(1);
        String version = "1.0";
        PackageManager m = getPackageManager();
        try {
            PackageInfo info = m.getPackageInfo("com.bignerdranch.android.enterpriseshow", 0);
            version = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mLoginUser.setAppVersion(version);
        mLoginUser.getObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        Toast.makeText(LoginActivity.this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick({R.id.register})
    void onClick() {
        startActivity(new Intent(LoginActivity.this, LoginRegisterActivity.class));
    }

    @OnClick(R.id.exit)
    void onClickExit() {
        finish();
    }
}
