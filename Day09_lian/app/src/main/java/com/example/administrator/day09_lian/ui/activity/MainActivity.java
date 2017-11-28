package com.example.administrator.day09_lian.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.administrator.day09_lian.R;
import com.example.administrator.day09_lian.ui.adapter.PagerAdapter;
import com.example.administrator.day09_lian.ui.fragment.CampusFragment;
import com.example.administrator.day09_lian.ui.fragment.ClassroomFragment;
import com.example.administrator.day09_lian.ui.fragment.EmploymentFragment;
import com.example.administrator.day09_lian.ui.fragment.HeadlineFragment;
import com.example.administrator.day09_lian.ui.fragment.PloyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTab;
    private ViewPager mPager;
    private ImageButton mButton;
    private ArrayList<Fragment> mList = new ArrayList<>();
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        mTab = (TabLayout) findViewById(R.id.tab);
        mPager = (ViewPager) findViewById(R.id.pager);
        mButton = (ImageButton) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTabActivity.class);
                startActivity(intent);
            }
        });

        mList.add(new HeadlineFragment());
        mList.add(new CampusFragment());
        mList.add(new EmploymentFragment());
        mList.add(new ClassroomFragment());
        mList.add(new PloyFragment());


        mPager.setAdapter(new PagerAdapter(fragmentManager,mList));


        mTab.addTab(mTab.newTab().setText("头条"));
        mTab.addTab(mTab.newTab().setText("校园"));
        mTab.addTab(mTab.newTab().setText("就业"));
        mTab.addTab(mTab.newTab().setText("课堂"));
        mTab.addTab(mTab.newTab().setText("活动"));

        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);

        mTab.setupWithViewPager(mPager);
        mTab.getTabAt(0).setText("头条");
        mTab.getTabAt(1).setText("校园");
        mTab.getTabAt(2).setText("就业");
        mTab.getTabAt(3).setText("课堂");
        mTab.getTabAt(4).setText("活动");



    }
}
