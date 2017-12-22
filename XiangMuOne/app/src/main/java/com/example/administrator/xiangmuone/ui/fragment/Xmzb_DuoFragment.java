package com.example.administrator.xiangmuone.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.Xmzb_Zb_DuoBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.MyXmzb_Zb_DuoAdapter;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Xmzb_DuoFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
private RecyclerView recyclerView;
    @Override
    protected void initView(View view) {
        recyclerView= (RecyclerView) view.findViewById(R.id.xmzb_duo_recy);

        Bundle arguments = getArguments();
        String url = arguments.getString("url");
        mPresenter.getModel(url);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xmzb__duo;
    }

    @Override
    public void show(String res) {
        Gson gson=new Gson();
        Xmzb_Zb_DuoBean xmzb_zb_duoBean = gson.fromJson(res, Xmzb_Zb_DuoBean.class);
        List<Xmzb_Zb_DuoBean.ListBean> list = xmzb_zb_duoBean.getList();

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new MyXmzb_Zb_DuoAdapter(list,getActivity()));

    }
}
