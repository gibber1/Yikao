package com.lwl.yikao.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.lwl.yikao.R;
import com.lwl.yikao.base.BaseBackFragment;
import com.lwl.yikao.bean.home;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by l_wl on 2016/6/7.
 */
public class HomeDetailFragment extends BaseBackFragment {
    private home mHome;
    private HtmlTextView mTVNewsContent;

    public static HomeDetailFragment newInstance(home HomeBean) {
        Bundle args = new Bundle();
        HomeDetailFragment fragment = new HomeDetailFragment();
        args.putSerializable("HomeBean", HomeBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHome = (home) getArguments().get("HomeBean");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_detail, null);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mTVNewsContent = (HtmlTextView) view.findViewById(R.id.htNewsContent);

        initToolbarNav(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mHome.getTitle());

        view.findViewById(R.id.ivImage).setBackgroundResource(mHome.getImgRes());
        if(mHome.getBody()!=null){
            mTVNewsContent.setHtmlFromString(mHome.getBody(), new HtmlTextView.LocalImageGetter());
        }
        else{
            mTVNewsContent.setHtmlFromString("<h>获取详情出错", new HtmlTextView.LocalImageGetter());
        }
        return view;
    }
}
