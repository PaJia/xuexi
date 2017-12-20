package com.example.administrator.xiangmuone.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.ShouYeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.ViewHolder>{
    List<ShouYeBean.DataBean.PandaliveBean.ListBean> list;
    Context context;

    public MyRecyAdapter(List<ShouYeBean.DataBean.PandaliveBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.myrecy_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.xc_image);
            textView= (TextView) itemView.findViewById(R.id.xc_te);
        }
    }
}
