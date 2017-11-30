package com.example.administrator.zhoukaotwo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.administrator.zhoukaotwo.R;

public class MainActivity extends AppCompatActivity {

    private TextView mHy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        AlphaAnimation animation=new AlphaAnimation(1.0f,1.0f);
        animation.setDuration(3000);
        mHy.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(MainActivity.this, ZhuYeActivity.class);
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    private void initView() {
        mHy = (TextView) findViewById(R.id.hy);
    }
}
