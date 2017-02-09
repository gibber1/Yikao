package com.lwl.yikao.home.view;

import com.lwl.yikao.bean.home;

import java.util.List;

/**
 * Created by l_wl on 2016/6/5.
 */

public interface HomeView {

    void showProgress();

    void adddata(List<home> homeList);

    void hideProgress();

    void showLoadFailMsg(String msg);
}

