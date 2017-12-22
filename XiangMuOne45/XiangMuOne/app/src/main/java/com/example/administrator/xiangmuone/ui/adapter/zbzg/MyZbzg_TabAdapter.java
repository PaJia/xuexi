package com.example.administrator.xiangmuone.ui.adapter.zbzg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.zbzg.Zbzg_recyBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyZbzg_TabAdapter extends RecyclerView.Adapter<MyZbzg_TabAdapter.ViewHolder>{
    List<Zbzg_recyBean.LiveBean> list;
    Context context;

    public MyZbzg_TabAdapter(List<Zbzg_recyBean.LiveBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.zbzg_fu_recy_item,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView1.setText(list.get(position).getBrief());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView,textView1;
        private CheckBox checkBox;
        public ViewHolder(final View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.xmzb_zb_st);
            textView= (TextView) itemView.findViewById(R.id.xmzb_zb_bt);
            textView1= (TextView) itemView.findViewById(R.id.xmzb_xy);
            checkBox= (CheckBox) itemView.findViewById(R.id.xmzb_zb_sx);

            checkBox.setButtonDrawable(R.drawable.live_china_detail_down);


            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        textView1.setVisibility(View.GONE);
                        checkBox.setButtonDrawable(R.drawable.live_china_detail_down);
                    } else {
                        checkBox.setButtonDrawable(R.drawable.live_china_detail_up);
                        textView1.setVisibility(View.VISIBLE);
                    }
                }

            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "sadfsdfsdf", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

}
