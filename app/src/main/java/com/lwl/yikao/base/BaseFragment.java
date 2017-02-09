package com.lwl.yikao.base;

import android.support.v4.view.GravityCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lwl.yikao.R;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by lwl on 16/11/19.
 */
public class BaseFragment extends SupportFragment {


    protected void initToolbarMenu(final Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.home);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tb_more:
                        final PopupMenu popupMenu = new PopupMenu(_mActivity, toolbar, GravityCompat.END);
                        popupMenu.inflate(R.menu.home_pop);
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.tb_more_setting:
                                        //TODO 跳转到设置页面
                                        break;
                                }
                                popupMenu.dismiss();
                                return true;
                            }
                        });
                        popupMenu.show();
                        break;
                }
                return true;
            }
        });
    }
}
