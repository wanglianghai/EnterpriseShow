package com.bignerdranch.android.enterpriseshow.adapter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailImgAc;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.uri.UriUtil;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/22/022.
 */
public class ImageBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CAMERA = 1;
    private static final int PICTURE = 2;

    private AppCompatActivity mContext;

    private List<ImageBean> mImageBeen;

    public ImageBaseAdapter(AppCompatActivity context, List<ImageBean> imageBeen) {
        mContext = context;
        mImageBeen = imageBeen;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return CAMERA;
        }

        return PICTURE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CAMERA) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.ac_site_detail_item_camera, parent, false);
            return new CameraHolder(v);
        } else {
            View v = LayoutInflater.from(mContext).inflate()
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mImageBeen.size();
    }

    public class CameraHolder extends RecyclerView.ViewHolder{

        public CameraHolder(View itemView) {
            super(itemView);
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height = BaseActivity.W / 4;
            itemView.setLayoutParams(params);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.image_camera)
        void onClick() {
            if (mContext instanceof SiteDetailActivity) {
                SiteDetailActivity siteDetailActivity = (SiteDetailActivity) mContext;
                siteDetailActivity.startActivity();
            }

            if (mContext instanceof SiteDetailImgAc) {
                SiteDetailImgAc siteDetailImgAc = (SiteDetailImgAc) mContext;
                offCamera(siteDetailImgAc);
            }
        }

        //1.file provider 的 uri
        //2.媒体存中抓取图片的intent
        private void offCamera(SiteDetailImgAc ac) {
            UriUtil.setPhotoFileUri(ac);
            Uri outUri = UriUtil.getPhotoFileUri();

            //对应的隐式的intent所要的信息
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outUri);

            //询问这个intent可以启动的activity
            List<ResolveInfo> captureActivities = ac.getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);

            for (ResolveInfo activity : captureActivities) {
                ac.grantUriPermission(activity.activityInfo.packageName, outUri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }

            ac.startActivityForResult(intent, SiteDetailImgAc.REQUEST_PHOTO);
        }
    }
}
