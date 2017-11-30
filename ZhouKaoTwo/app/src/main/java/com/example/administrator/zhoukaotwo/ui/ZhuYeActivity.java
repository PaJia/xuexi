package com.example.administrator.zhoukaotwo.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.administrator.zhoukaotwo.R;
import com.example.administrator.zhoukaotwo.base.BaseActivity;
import com.example.administrator.zhoukaotwo.bean.MyBean;
import com.example.administrator.zhoukaotwo.net.NetContract;
import com.example.administrator.zhoukaotwo.net.NetModel;
import com.example.administrator.zhoukaotwo.net.NetPresenter;
import com.example.administrator.zhoukaotwo.ui.adapter.MyShouYeAdapter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;
import java.util.List;

public class ZhuYeActivity extends BaseActivity<NetPresenter,NetModel> implements NetContract.View{

    private RecyclerView mRecy;
    private Banner mBanner;
    private RecyclerViewHeader mRecyvh;
    private MyShouYeAdapter adapter;
    private ArrayList<Integer> mList=new ArrayList<>();


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
        presenter.getDataFromModel("http://172.16.44.48:8080/json/data.json");
    }

    protected void initView() {
        mRecy = (RecyclerView) findViewById(R.id.recy);
        mBanner = (Banner) findViewById(R.id.banner);
        mRecyvh = (RecyclerViewHeader) findViewById(R.id.recyvh);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhu_ye;
    }

    @Override
    public void show(String res) {
        Gson gson=new Gson();
        MyBean myBean = gson.fromJson(res, MyBean.class);
        List<MyBean.ResultBean.DataBean> data = myBean.getResult().getData();

        mRecy.setLayoutManager(new LinearLayoutManager(ZhuYeActivity.this));

        adapter=new MyShouYeAdapter((ArrayList<MyBean.ResultBean.DataBean>) data,ZhuYeActivity.this);
        mRecy.setAdapter(adapter);

        mRecyvh.attachTo(mRecy,true);

        adapter.setOnClick(new MyShouYeAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Intent intent=new Intent(ZhuYeActivity.this,TuCeActivity.class);
                startActivity(intent);
            }
        });

    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

}
