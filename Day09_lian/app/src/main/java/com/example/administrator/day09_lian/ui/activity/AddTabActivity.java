package com.example.administrator.day09_lian.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.day09_lian.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AddTabActivity extends AppCompatActivity {
    private Context mContext;
    private MainActiviyView xGridView;
    private List<HashMap<String,Object>> dataSourceList = new ArrayList<>();
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tab);
        initData();
        initView();
    }
    private void initView() {
        xGridView = (MainActiviyView) findViewById(R.id.view_drag);
        xGridView.setAdapter(adapter);
        xGridView.setOnItemChangeListener(new MainActiviyView.OnItemChangeListener() {
            @Override
            public void onChange(int from, int to) {
                Toast.makeText(mContext,"From:" + from + "  To:" + to,Toast.LENGTH_LONG);

                HashMap<String, Object> temp = dataSourceList.get(from);
                //直接交互
                //Collections.swap(dataSourceList,from,to);

                //非直接交互 这里的处理需要注意下 排序交换
                if(from < to){
                    for(int i = from; i < to; i++){
                        Collections.swap(dataSourceList, i, i+1);
                    }
                }else if(from > to){
                    for(int i = from; i > to; i--){
                        Collections.swap(dataSourceList, i, i-1);
                    }
                }
                dataSourceList.set(to, temp);

                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        mContext = this;
        for (int i = 0; i < 30;i++){
            HashMap<String,Object> itemMap = new HashMap<>();
            itemMap.put("item_text","拖拽" + i);
            dataSourceList.add(itemMap);
        }
        adapter = new SimpleAdapter(this,dataSourceList,R.layout.item_drag
                ,new String[]{"item_image","item_text"},new int[]{R.id.item_image,R.id.item_text});
    }

}
