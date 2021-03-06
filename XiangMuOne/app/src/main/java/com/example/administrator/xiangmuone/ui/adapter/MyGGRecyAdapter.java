package com.example.administrator.xiangmuone.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.SY_GgspBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyGGRecyAdapter extends RecyclerView.Adapter<MyGGRecyAdapter.ViewHolder>{
    List<SY_GgspBean.ListBean>  list;
    Context context;

    public MyGGRecyAdapter(List<SY_GgspBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.ggsp_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getDaytime());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView,textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.xc_image);
            textView= (TextView) itemView.findViewById(R.id.xc_te);
            textView2= (TextView) itemView.findViewById(R.id.xc_sj);
        }
    }
}
