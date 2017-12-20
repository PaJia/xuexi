package com.example.administrator.xiangmuone.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.Xmzb_ZbBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiBoFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private ImageView mImageView;
    private TextView mTextView,mXy;
    private CheckBox checkBox;

    @Override
    protected void initView(View view) {

        Bundle bundle = getArguments();
        String url = bundle.getString("url");

        mPresenter.getModel(url);

        mImageView = (ImageView) view.findViewById(R.id.xmzb_zb_st);
        mTextView = (TextView) view.findViewById(R.id.xmzb_zb_bt);
        mXy = (TextView) view.findViewById(R.id.xmzb_xy);
        checkBox = (CheckBox) view.findViewById(R.id.xmzb_zb_sx);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mXy.setVisibility(View.GONE);
                    checkBox.setButtonDrawable(R.drawable.live_china_detail_down);
                } else {
                    checkBox.setButtonDrawable(R.drawable.live_china_detail_up);
                    mXy.setVisibility(View.VISIBLE);
                }
            }

        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_bo;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        Xmzb_ZbBean xmzb_zbBean = gson.fromJson(res, Xmzb_ZbBean.class);
        List<Xmzb_ZbBean.LiveBean> live = xmzb_zbBean.getLive();

        mTextView.setText(live.get(0).getTitle());
        mXy.setText(live.get(0).getBrief());
        Glide.with(getActivity()).load(live.get(0).getImage()).into(mImageView);

    }
}
