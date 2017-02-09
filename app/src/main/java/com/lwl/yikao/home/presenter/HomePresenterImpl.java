package com.lwl.yikao.home.presenter;

import com.lwl.yikao.bean.home;
import com.lwl.yikao.home.model.HomeModel;
import com.lwl.yikao.home.model.HomeModelImpl;
import com.lwl.yikao.home.view.HomeView;

import java.util.List;

/**
 * Created by l_wl on 2016/6/5.
 */
public class HomePresenterImpl implements HomePresenter,HomeModelImpl.OnLoadDataListListener {

    private HomeView mHomeView;
    private HomeModel mHomeModel;

    public HomePresenterImpl(HomeView homeView) {
        this.mHomeView = homeView;
        this.mHomeModel = new HomeModelImpl();
    }

    @Override
    public void loaddata(int type, int page) {
        mHomeModel.loaddata(this);

    }

    @Override
    public void onSuccess(List<home> list) {
        mHomeView.adddata(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
