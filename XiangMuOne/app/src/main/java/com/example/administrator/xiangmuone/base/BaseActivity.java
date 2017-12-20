package com.example.administrator.xiangmuone.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.utils.App;
import com.example.administrator.xiangmuone.utils.TUtils;

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements View.OnClickListener {
    public P mPresenter;
    public M mModel;
    private FrameLayout frameLayout;
    public static TextView mTitle;
    public static ImageView mImage,mImages,mImagess;
    public static ImageButton mSy;
    public static ImageButton mXmzb;
    public static ImageButton mGgsp;
    public static ImageButton mXmbb;
    public static ImageButton mZbzg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        mTitle = (TextView) findViewById(R.id.title);
        mImage = (ImageView) findViewById(R.id.tab_image);
        mImages = (ImageView) findViewById(R.id.hd);
        mImagess= (ImageView) findViewById(R.id.imageView);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        mImage.setOnClickListener(this);
        mImages.setOnClickListener(this);
        mImagess.setOnClickListener(this);
        App.baseActivity = this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setMV(mModel, this);
        }
        initView();
    }

    protected abstract void initView();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

    }

    @Override
    public void setContentView(View view) {
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void onClick(View v) {
    }
}
