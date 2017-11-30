package com.example.administrator.zhoukaotwo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.zhoukaotwo.R;
import com.example.administrator.zhoukaotwo.bean.MyBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/30.
 */
public class MyShouYeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;
    public static final int Three_ITEM = 3;
    private ArrayList<MyBean.ResultBean.DataBean> mList;
    private Context context;
    private View v;

    public MyShouYeAdapter(ArrayList<MyBean.ResultBean.DataBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater view = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder;
        if (viewType == ONE_ITEM) {
            v = view.inflate(R.layout.shouye_mobai_one, parent, false);
            holder = new ViewHolderOne(v);
        } else if (viewType == TWO_ITEM) {
            v = view.inflate(R.layout.shouye_mobai_two, parent, false);
            holder = new ViewHolderTwo(v);

        } else {
            v = view.inflate(R.layout.shouye_mobai_three, parent, false);
            holder = new ViewHolderThree(v);
        }
        v.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolderOne) {
            ((ViewHolderOne) holder).mBt_one.setText(mList.get(position).getTitle());
            ((ViewHolderOne) holder).mNr_one.setText(mList.get(position).getAuthor_name());
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s()).into(((ViewHolderOne) holder).mImage_one);
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewHolderTwo) {
            ((ViewHolderTwo) holder).mBt_two.setText(mList.get(position).getTitle());
            ((ViewHolderTwo) holder).mNr_two.setText(mList.get(position).getAuthor_name());
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s()).into(((ViewHolderTwo) holder).mImage_two_one);
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s02()).into(((ViewHolderTwo) holder).mImage_two_two);
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewHolderThree) {
            ((ViewHolderThree) holder).mBt_three.setText(mList.get(position).getTitle());
            ((ViewHolderThree) holder).mNr_three.setText(mList.get(position).getAuthor_name());
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s()).into(((ViewHolderThree) holder).mImage_three_one);
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s02()).into(((ViewHolderThree) holder).mImage_three_two);
            Glide.with(context).load(mList.get(position).getThumbnail_pic_s03()).into(((ViewHolderThree) holder).mImage_three_three);
            holder.itemView.setTag(position);
        }

    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return ONE_ITEM;
        } else if (position == 2) {
            return TWO_ITEM;
        } else {
            return Three_ITEM;
        }
    }

    private class ViewHolderOne extends RecyclerView.ViewHolder {
        private TextView mBt_one, mNr_one;
        private ImageView mImage_one;

        public ViewHolderOne(View itemView) {
            super(itemView);
            mBt_one = (TextView) itemView.findViewById(R.id.bt_one);
            mNr_one = (TextView) itemView.findViewById(R.id.nr_one);
            mImage_one = (ImageView) itemView.findViewById(R.id.image_one_one);
        }
    }

    private class ViewHolderTwo extends RecyclerView.ViewHolder {
        private TextView mBt_two, mNr_two;
        private ImageView mImage_two_one, mImage_two_two;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            mBt_two = (TextView) itemView.findViewById(R.id.bt_two);
            mNr_two = (TextView) itemView.findViewById(R.id.nr_two);
            mImage_two_one = (ImageView) itemView.findViewById(R.id.image_two_one);
            mImage_two_two = (ImageView) itemView.findViewById(R.id.image_two_two);
        }
    }

    private class ViewHolderThree extends RecyclerView.ViewHolder {
        private TextView mBt_three, mNr_three;
        private ImageView mImage_three_one, mImage_three_two, mImage_three_three;

        public ViewHolderThree(View itemView) {
            super(itemView);
            mBt_three = (TextView) itemView.findViewById(R.id.bt_three);
            mNr_three = (TextView) itemView.findViewById(R.id.nr_three);
            mImage_three_one = (ImageView) itemView.findViewById(R.id.image_three_one);
            mImage_three_two = (ImageView) itemView.findViewById(R.id.image_three_two);
            mImage_three_three = (ImageView) itemView.findViewById(R.id.image_three_three);

        }
    }

    public interface OnClickItem {
        void setClick(View v, int position);
    }

    private OnClickItem item;

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
