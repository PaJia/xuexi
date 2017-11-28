package com.example.administrator.day09_lian.net;

/**
* Created by TMVPHelper on 2017/11/28
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