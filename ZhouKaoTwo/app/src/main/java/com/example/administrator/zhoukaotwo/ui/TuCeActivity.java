package com.example.administrator.zhoukaotwo.ui;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.zhoukaotwo.R;
import com.example.administrator.zhoukaotwo.base.BaseActivity;
import com.example.administrator.zhoukaotwo.net.NetContract;
import com.example.administrator.zhoukaotwo.net.NetModel;
import com.example.administrator.zhoukaotwo.net.NetPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;

public class TuCeActivity extends BaseActivity<NetPresenter, NetModel> implements NetContract.View {
    private ArrayList<Integer> mList = new ArrayList<>();
    private Banner mBanner;

    @Override
    protected void initBann() {
        mList.add(R.drawable.a);
        mList.add(R.drawable.b);
        mList.add(R.drawable.c);
        mList.add(R.drawable.d);

        mBanner.setImages(mList)
                .setDelayTime(2000)
                .setImageLoader(new GlideImage())
                .setIndicatorGravity(BannerConfig.CENTER)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setBannerAnimation(CubeOutTransformer.class)
                .start();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tu_ce;
    }

    @Override
    public void show(String res) {

    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

}
