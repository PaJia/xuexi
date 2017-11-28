package com.example.administrator.day09_lian.ui.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.administrator.day09_lian.R;
import com.example.administrator.day09_lian.base.BaseFragment;
import com.example.administrator.day09_lian.bean.HeadlineBean;
import com.example.administrator.day09_lian.net.NetContract;
import com.example.administrator.day09_lian.net.NetModel;
import com.example.administrator.day09_lian.net.NetPresenter;
import com.example.administrator.day09_lian.ui.adapter.HeadlineAdapter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CampusFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private Banner mBanner;
    private RecyclerView mRecy;
    private RecyclerViewHeader mHeader;
    ArrayList<String> mList = new ArrayList<>();
    private String mUrl = "http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&controller=content&catid=2&page=1&action=index&time=0 ";
    private HeadlineAdapter headlineAdapter;

    @Override
    protected void initBan() {

        mList.add("http://upload.univs.cn/2017/1127/thumb_640_314_1511748883720.jpg");
        mList.add("http://upload.univs.cn/2017/0927/1506480713100.png");
        mList.add("http://upload.univs.cn/2017/0927/thumb_640_314_1506480759630.jpg");

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
        presenter.getDataFromModel(mUrl);
    }

    @Override
    protected void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);
        mBanner = (Banner) view.findViewById(R.id.banner);
        mHeader = (RecyclerViewHeader) view.findViewById(R.id.recyvh);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_headline;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        HeadlineBean headlineBean = gson.fromJson(res, HeadlineBean.class);
        List<HeadlineBean.DataBean> movies = headlineBean.getData();
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        headlineAdapter = new HeadlineAdapter(getActivity(), (ArrayList<HeadlineBean.DataBean>) movies);
        mRecy.setAdapter(headlineAdapter);
        mHeader.attachTo(mRecy, true);
        headlineAdapter.setOnClick(new HeadlineAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Toast.makeText(getActivity(), "图格斯", Toast.LENGTH_SHORT).show();
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
