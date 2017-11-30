package com.example.administrator.zhoukaotwo.net;

/**
* Created by TMVPHelper on 2017/11/30
*/
public class NetPresenter extends NetContract.Presenter{

    @Override
   public void getDataFromModel(String url) {
        baseModel.getDataFromNet(url, new CallBacks() {
            @Override
            public void succ(String result) {
                baseView.show(result);
            }
        });
    }
}