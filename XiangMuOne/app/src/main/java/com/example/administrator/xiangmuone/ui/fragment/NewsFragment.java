package com.example.administrator.xiangmuone.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {

    private TextView textView;


    @Override
    protected void initView(View view) {
        textView= (TextView) view.findViewById(R.id.asdf);

        Bundle bundle = getArguments();
        String index = bundle.getString("murl");
        textView.setText(index);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void show(String res) {

    }
}
