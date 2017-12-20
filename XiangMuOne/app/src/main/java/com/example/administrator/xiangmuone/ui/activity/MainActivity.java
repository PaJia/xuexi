package com.example.administrator.xiangmuone.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseActivity;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.fragment.XmzbFragment;
import com.example.administrator.xiangmuone.ui.fragment.CFragment;
import com.example.administrator.xiangmuone.ui.fragment.DFragment;
import com.example.administrator.xiangmuone.ui.fragment.EFragment;
import com.example.administrator.xiangmuone.ui.fragment.ShouYeFragment;

public class MainActivity extends BaseActivity<NetPresenter, NetModel> implements View.OnClickListener,NetContract.View {


    private View view;

    private ShouYeFragment mAFragment;
    private XmzbFragment mBFragment;
    private CFragment mCFragment;
    private DFragment mDFragment;
    private EFragment mEFragment;
    private FragmentManager manager;

    @Override
    protected void initView() {
        view = View.inflate(this, R.layout.activity_main, null);
        setContentView(view);
        mAFragment = new ShouYeFragment();
        mBFragment = new XmzbFragment();
        mCFragment = new CFragment();
        mDFragment = new DFragment();
        mEFragment = new EFragment();


        manager = getSupportFragmentManager();
        mSy = (ImageButton)findViewById(R.id.sy);
        mXmzb = (ImageButton)findViewById(R.id.xmzb);
        mGgsp = (ImageButton)findViewById(R.id.ggsp);
        mXmbb = (ImageButton)findViewById(R.id.xmbb);
        mZbzg = (ImageButton)findViewById(R.id.zbzg);
        mSy.setOnClickListener(this);
        mSy.performClick();
        mXmzb.setOnClickListener(this);
        mGgsp.setOnClickListener(this);
        mXmbb.setOnClickListener(this);
        mZbzg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sy:
                FragmentTransaction ta = manager.beginTransaction();
                ta.replace(R.id.frame, mAFragment);
                mTitle.setVisibility(View.GONE);
                mImage.setVisibility(View.VISIBLE);
                mImages.setVisibility(View.VISIBLE);
                ta.commit();
                break;
            case R.id.xmzb:
                FragmentTransaction tb = manager.beginTransaction();
                tb.replace(R.id.frame, mBFragment);
                mTitle.setText("熊猫直播");
                mTitle.setVisibility(View.VISIBLE);
                mImage.setVisibility(View.GONE);
                mImages.setVisibility(View.GONE);
                tb.commit();
                break;
            case R.id.ggsp:
                FragmentTransaction tc = manager.beginTransaction();
                tc.replace(R.id.frame, mCFragment);
                mTitle.setText("滚滚视频");
                mTitle.setVisibility(View.VISIBLE);
                mImage.setVisibility(View.GONE);
                mImages.setVisibility(View.GONE);
                tc.commit();
                break;
            case R.id.xmbb:
                FragmentTransaction td = manager.beginTransaction();
                td.replace(R.id.frame, mDFragment);
                mTitle.setText("熊猫播报");
                mTitle.setVisibility(View.VISIBLE);
                mImage.setVisibility(View.GONE);
                mImages.setVisibility(View.GONE);
                td.commit();
                break;
            case R.id.zbzg:
                FragmentTransaction te = manager.beginTransaction();
                te.replace(R.id.frame, mEFragment);
                mTitle.setText("直播中国");

                mTitle.setVisibility(View.VISIBLE);
                mImage.setVisibility(View.GONE);
                mImages.setVisibility(View.GONE);
                te.commit();
                break;
            case R.id.hd:
                Toast.makeText(MainActivity.this, "asdfasdfsf", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView:
                Toast.makeText(MainActivity.this, "sddfgerret", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void show(String res) {

    }
}
