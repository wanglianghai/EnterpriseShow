package com.bignerdranch.android.enterpriseshow.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SectionsPagerAdapter;
import com.bignerdranch.android.enterpriseshow.bean.Login;
import com.bignerdranch.android.enterpriseshow.bean.LoginBean;
import com.bignerdranch.android.enterpriseshow.bean.User;
import com.bignerdranch.android.enterpriseshow.db.LoginTable;
import com.bignerdranch.android.enterpriseshow.db.ShowTable;
import com.bignerdranch.android.enterpriseshow.fragment.HomeFrag;
import com.bignerdranch.android.enterpriseshow.fragment.MsgFrag;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/3/003.
 */

public class Control {
    private static final String TAG = "Control";
    public void login(final String userName, final String passWord, final AppCompatActivity activity, final SectionsPagerAdapter adapter) {
        Login mLoginUser = new Login();
        mLoginUser.setUserName(userName);
        mLoginUser.setPassWord(passWord);
        String version = "1.0";
        PackageManager m = activity.getPackageManager();
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
                        if (activity instanceof LoginActivity) {
                            Toast.makeText(activity, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                            activity.finish();

                            LoginTable table = new LoginTable();
                            table.setUsername(userName);
                            table.setPassword(passWord);
                            table.save();
                            List<LoginTable> tables = DataSupport.findAll(LoginTable.class);
                            ShowTable showTable = new ShowTable();
                            showTable.setLastId(tables.size());
                            showTable.save();
                            showTable.update(1);
                        }

                        User.getUser().setId((long) loginBean.getData().getId());
                        User.getUser().setSessionId(loginBean.getData().getSessionId());
                        Log.i(TAG, "accept: " + User.getUser().toString());

                        if (activity instanceof MainActivity) {
                            if (adapter == null) {
                                return;
                            }
                            HomeFrag f = (HomeFrag) adapter.getSparseArray(0);
                            if (f != null) {
                                f.showRecord();
                            }
                        }

                    }
                });
    }
}
