package com.example.administrator.xiangmuone.ui.adapter.xmbb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.bean.xmbb.XmbbBean;

import java.util.List;


/**
 * Created by Administrator on 2017/12/19.
 */
public class MyXmbbRecyAdapter extends RecyclerView.Adapter<MyXmbbRecyAdapter.ViewHolder> implements View.OnClickListener {
    List<XmbbBean.ListBean> list;
    Context context;

    public MyXmbbRecyAdapter(List<XmbbBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ggsp_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView2.setText(null);
        Glide.with(context).load(list.get(position).getPicurl()).into(holder.imageView);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView, textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.xc_image);
            textView = (TextView) itemView.findViewById(R.id.xc_te);
            textView2 = (TextView) itemView.findViewById(R.id.xc_sj);
        }
    }
    public interface OnClickItem {
        void setClick(View v, int position);
    }

    private OnClickItem item=null;

    @Override
    public void onClick(View v) {
        if (item != null) {
            item.setClick(v, (int) v.getTag());
        }
    }

    public void setOnClick(OnClickItem item) {
        this.item = item;
    }
}
