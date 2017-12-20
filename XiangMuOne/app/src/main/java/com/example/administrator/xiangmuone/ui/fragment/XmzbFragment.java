package com.example.administrator.xiangmuone.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.XmzbBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.PagerAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class XmzbFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private TabLayout tabLayout;
    private ViewPager pager;
    private FragmentManager fragmentManager;
    private XmzbBean xmzbBean;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> mlist = new ArrayList<>();
    private List<XmzbBean.TablistBean> tablist;

    @Override
    protected void initView(View view) {
        fragmentManager=getFragmentManager();
        mPresenter.getModel("http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json");

        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        pager= (ViewPager) view.findViewById(R.id.pager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        xmzbBean = gson.fromJson(res, XmzbBean.class);
        tablist = xmzbBean.getTablist();

        for (int i = 0; i < tablist.size(); i++) {
            list.add(tablist.get(i).getTitle());
        }
        initFragment();

    }


    private void initFragment() {

        mlist.clear();
        ZhiBoFragment zhiBoFragment=new ZhiBoFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("url", tablist.get(0).getUrl());
        zhiBoFragment.setArguments(bundle1);

        mlist.add(zhiBoFragment);
        for (int i = 1; i < tablist.size(); i++) {
            NewsFragment newfragment = new NewsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("murl", tablist.get(i).getTitle());
            newfragment.setArguments(bundle);
            mlist.add(newfragment);
        }
        PagerAdapter mAdapetr = new PagerAdapter(fragmentManager,list, mlist);
        pager.setAdapter(mAdapetr);
        tabLayout.setupWithViewPager(pager);
    }

}
