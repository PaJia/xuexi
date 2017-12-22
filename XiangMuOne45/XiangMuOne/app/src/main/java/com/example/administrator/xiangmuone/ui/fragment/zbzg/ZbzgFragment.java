package com.example.administrator.xiangmuone.ui.fragment.zbzg;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.zbzg.Zbzg_ZhuBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.PagerAdapter;
import com.example.administrator.xiangmuone.utils.App;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbzgFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private TabLayout tabLayout;
    private ViewPager pager;
    private FragmentManager fragmentManager;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> mlist = new ArrayList<>();

    @Override
    protected void initView(View view) {
        App.baseFragment = this;
        fragmentManager = getFragmentManager();
        mPresenter.getModel("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");

        tabLayout= (TabLayout) view.findViewById(R.id.zbzg_tab);
        pager= (ViewPager) view.findViewById(R.id.zbzg_pager);



    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_e;
    }

    @Override
    public void show(String res) {
        Gson gson=new Gson();
        Zbzg_ZhuBean zbzg_zhuBean = gson.fromJson(res, Zbzg_ZhuBean.class);

        List<Zbzg_ZhuBean.TablistBean> tablist = zbzg_zhuBean.getTablist();

        for (int i = 0; i < tablist.size(); i++) {
            list.add(tablist.get(i).getTitle());

            mlist.clear();
            for (int j = 0; j < list.size(); j++) {
                Zbzg_FuYongFragment fyfragment=new Zbzg_FuYongFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url", tablist.get(j).getUrl());
                fyfragment.setArguments(bundle);
                mlist.add(fyfragment);
            }
            PagerAdapter mAdapetr = new PagerAdapter(fragmentManager, list, mlist);
            tabLayout.setupWithViewPager(pager);
            pager.setAdapter(mAdapetr);
            mAdapetr.notifyDataSetChanged();


        }


    }
}
