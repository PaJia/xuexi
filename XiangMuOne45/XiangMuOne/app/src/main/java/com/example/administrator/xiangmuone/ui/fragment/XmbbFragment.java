package com.example.administrator.xiangmuone.ui.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.xmbb.XmbbBean;
import com.example.administrator.xiangmuone.bean.xmbb.Xmbb_zhuBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.xmbb.MyXmbbRecyAdapter;
import com.example.administrator.xiangmuone.utils.App;
import com.example.administrator.xiangmuone.utils.Callbacks;
import com.example.administrator.xiangmuone.utils.Ok;
import com.google.gson.Gson;

import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerView;


public class XmbbFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private LFRecyclerView recyclerView;
    private ImageView imageView;
    private TextView textView;
    private Xmbb_zhuBean xmbb_zhuBean;


    @Override
    protected void initView(View view) {
        App.baseFragment = this;
        mPresenter.getModel("http://www.ipanda.com/kehuduan/news/index.json");

        recyclerView = (LFRecyclerView) view.findViewById(R.id.xmbb_lf_recy);
        recyclerView.setLoadMore(true);
        recyclerView.setRefresh(true);
        View veiwss= LayoutInflater.from(getActivity()).inflate(R.layout.ggsp_tou,null);

        imageView= (ImageView) veiwss.findViewById(R.id.gg_tou_image);
        textView= (TextView) veiwss.findViewById(R.id.gg_tou_text);

        recyclerView.setHeaderView(veiwss);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_d;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        xmbb_zhuBean = gson.fromJson(res, Xmbb_zhuBean.class);

        Glide.with(getActivity()).load(xmbb_zhuBean.getData().getBigImg().get(0).getImage()).into(imageView);
        textView.setText(xmbb_zhuBean.getData().getBigImg().get(0).getTitle());


        initRecy();
    }

    private void initRecy() {
        String listurl = xmbb_zhuBean.getData().getListurl();


        Ok.getTran().sendGet(listurl, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                Gson gson1 = new Gson();
                XmbbBean xmbbBean = gson1.fromJson(string, XmbbBean.class);
                List<XmbbBean.ListBean> list = xmbbBean.getList();
                recyclerView.setAdapter(new MyXmbbRecyAdapter(list, getActivity()));
            }
        });
    }
}
