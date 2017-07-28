package com.bignerdranch.android.enterpriseshow.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.adapter.SiteDetailImgAdapter;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.bean.ImageLibrary;
import com.bignerdranch.android.enterpriseshow.click.ImageSelectClicked;
import com.bignerdranch.android.enterpriseshow.uri.UriUtil;
import com.bignerdranch.android.enterpriseshow.util.MPermissionUtil;
import com.bignerdranch.android.enterpriseshow.views.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SiteDetailImgAc extends AppCompatActivity implements ImageSelectClicked {
    private static final String TAG = "SiteDetailImgAc";
    public static final int REQUEST_PHOTO = 0;

    @Bind(R.id.img_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.button_confirm)
    Button mButtonConfirm;

    private SiteDetailImgAdapter mImgAdapter;
    private List<ImageBean> mImageBeen;

    //接收子线程下载完成信息的handler
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //做一些下载完成后的工作
            mImageBeen.size();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_detail_img);
        ButterKnife.bind(this);

        //发送需要得到的权限
        MPermissionUtil.requestPermissionResult(this, 1, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE});
        mImageBeen = new ArrayList<>();

        //第一个放自己的图片
        mImageBeen.add(null);
        mImgAdapter = new SiteDetailImgAdapter(this, mImageBeen);
        mRecyclerView.setAdapter(mImgAdapter);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        buConfirmSetText();
        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getImageList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case REQUEST_PHOTO:
                Uri uri = UriUtil.getPhotoFileUri();

                Log.i(TAG, "onActivityResult: photo");
                ImageBean image = new ImageBean(UriUtil.getPhotoFileString());
                ImageLibrary.get().getImageBeen().add(image);
                setResult(Activity.RESULT_OK);
                this.finish();
                break;
        }
    }

    private void getImageList() {
        ImageDirThread thread = new ImageDirThread(this, mHandler);
        thread.start();
    }

    @Override
    public void clickImage(int position) {
        ImageBean bean = mImageBeen.get(position);
        if (ImageLibrary.get().contain(bean)) {
            //bean要全部一样
            ImageLibrary.get().getImageBeen().remove(bean);
            bean.setSelected(false);
            buConfirmSetText();
            return;
        }
        bean.setSelected(true);
        ImageLibrary.get().getImageBeen().add(bean);
        if (ImageLibrary.get().getImageBeen().size() >= 9) {
            Toast.makeText(this, "最多只能上传9张图片", Toast.LENGTH_SHORT).show();
            return;
        }
        buConfirmSetText();
    }

    private void buConfirmSetText() {
        String numString = ImageLibrary.get().getImageBeen().size() + "";
        mButtonConfirm.setText("确定 " + numString + "/9");
    }

    //异步线程寻找图片位置(有数据的修改放里面方便)
    private class ImageDirThread extends Thread {
        private AppCompatActivity mActivity;
        private Handler mHandler;
        private ImageDirThread(AppCompatActivity activity, Handler handler) {
            mActivity = activity;
            mHandler = handler;
        }
        @Override
        public void run() {
            super.run();

            //用cursor读app外部的图片地址，要读的权限
            Cursor cursor = getCursor();
            //判断是否存在图片
            if (cursor.getCount() > 0) {

                //移动cursor
                while (cursor.moveToNext()) {
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    inImages(path);
                }
                //cursor要关闭
                cursor.close();
            }

            //通知主线程完成查询,里面值随便写的，反正
            mHandler.sendEmptyMessage(0x110);
        }

        private void inImages(String path) {
            ImageBean bean = new ImageBean(path);
            mImageBeen.add(bean);
        }

        private Cursor getCursor() {
            //要通过内容解析器解析出png和jpeg格式的图片（通过内容解析器可以得到所有的系统东西）
            ContentResolver resolver = mActivity.getContentResolver();
            //获取内存卡Uri:媒体储存中的图片中的媒体外部uri,（里面的一些表名，字段名）
            //第三个where第四个where args
            Uri memoryCar = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            return resolver.query(memoryCar, null,
                    MediaStore.Images.Media.MIME_TYPE + "=? or " +
                            MediaStore.Images.Media.MIME_TYPE + "=?",
                    new String[]{"image/png", "image/jpeg"},
                    MediaStore.Images.Media.DATE_MODIFIED);
        }
    }
}
