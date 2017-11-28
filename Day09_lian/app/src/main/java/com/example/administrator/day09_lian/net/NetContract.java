package com.example.administrator.day09_lian.net;

import com.example.administrator.day09_lian.base.BaseModel;
import com.example.administrator.day09_lian.base.BasePresenter;
import com.example.administrator.day09_lian.base.BaseView;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface NetContract {

    interface View extends BaseView {
        void show(String res);
      
    }

    interface Model extends BaseModel {
        void getDataFromNet(String url,CallBacks callBacks);


    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
       public abstract void getDataFromModel(String url);
        
    }
}