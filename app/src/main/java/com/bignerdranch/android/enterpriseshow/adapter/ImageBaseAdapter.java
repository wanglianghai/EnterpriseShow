package com.bignerdranch.android.enterpriseshow.adapter;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bignerdranch.android.enterpriseshow.R;
import com.bignerdranch.android.enterpriseshow.activity.BaseActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailActivity;
import com.bignerdranch.android.enterpriseshow.activity.SiteDetailImgAc;
import com.bignerdranch.android.enterpriseshow.bean.ImageBean;
import com.bignerdranch.android.enterpriseshow.bean.ImageLibrary;
import com.bignerdranch.android.enterpriseshow.click.ImageSelectClicked;
import com.bignerdranch.android.enterpriseshow.uri.UriUtil;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/22/022.
 */
//根据数据加载图片，和对应的点击事件，holder为1/4的屏宽度
public abstract class ImageBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int CAMERA = 1;
    private static final int PICTURE = 2;

    private AppCompatActivity mContext;
    private ImageSelectClicked mClicked;

    private List<ImageBean> mImageBeen;

    public abstract void click(CheckBox checkBox);
    public ImageBaseAdapter(AppCompatActivity context, List<ImageBean> imageBeen) {
        mContext = context;
        mClicked = (ImageSelectClicked) context;
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
            return new CameraHolder(getView(R.layout.ac_site_detail_item_camera, parent));
        } else {
            return new ImageHolder(getView(R.layout.ac_site_detail_item_img, parent));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position > 0) {
            ImageHolder item = (ImageHolder) holder;
            item.bind(mImageBeen.get(position));
        }
    }

    private View getView(int layoutRes, ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(layoutRes, parent, false);
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

    class ImageHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.image)
        ImageView mImageView;
        @Bind(R.id.checkbox_image)
        CheckBox mCheckBox;
        private View mView;

        public ImageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mCheckBox.setClickable(false);

            mView = itemView;
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height = BaseActivity.W / 4;
            itemView.setLayoutParams(params);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click(mCheckBox);
                    //发生点击事件后的动作
                    mClicked.clickImage(getAdapterPosition());
                }
            });
        }

        public void bind(ImageBean bean) {
            //没给出大小不能设置（133-135itemView.setLayoutParams(params);）
            Glide.with(mContext).load(bean.getImagePath()).into(mImageView);
            mCheckBox.setChecked(bean.isSelected());
            if (ImageLibrary.get().contain(bean)) {
                mCheckBox.setChecked(true);
            }
            if (ImageLibrary.get().getImageBeen().size() >= 9) {
                if (!mCheckBox.isChecked()) {
                    cannotSelect();
                } else {
                    canSelect();
                }
            } else {
                canSelect();
            }
        }

        public void canSelect() {
            mView.setClickable(true);
            mView.setAlpha(1.0f);
        }

        public void cannotSelect() {
            mView.setClickable(false);
            mView.setAlpha(0.5f);
        }
    }
}
