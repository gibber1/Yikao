package com.lwl.yikao.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.lwl.yikao.R;
import com.lwl.yikao.base.BaseLazyMainFragment;
import com.lwl.yikao.bean.home;
import com.lwl.yikao.event.StartBrotherEvent;
import com.lwl.yikao.helper.OnItemClickListener;
import com.lwl.yikao.home.adapter.HomeAdapter;
import com.lwl.yikao.home.presenter.HomePresenter;
import com.lwl.yikao.home.presenter.HomePresenterImpl;
import com.lwl.yikao.home.view.HomeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class HomeFragment extends BaseLazyMainFragment implements Toolbar.OnMenuItemClickListener,
        HomeView {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private HomePresenter mHomePresenter;
    private HomeAdapter mAdapter;
    private List<home> mData;
    private int pageIndex = 0;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomePresenter = new HomePresenterImpl(this);
    }

    @Override
    protected void initLazyView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);
        mHomePresenter.loaddata(1, pageIndex);
        return view;
    }


    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.home);
        initToolbarMenu(mToolbar);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recy);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new HomeAdapter(_mActivity);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
/*                start(HomeDetailFragment.newInstance(mAdapter.getItem(position)), SupportFragment.SINGLETASK);*/
                EventBus.getDefault().post(new StartBrotherEvent(HomeDetailFragment.newInstance(mAdapter.getItem(position))));
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }
    };


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void adddata(List<home> homeList) {
        if (mData == null) {
            mData = new ArrayList<home>();
        }
        mData.addAll(homeList);
        mAdapter.setmDate(mData);
    }


    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg(String msg) {

    }

}
