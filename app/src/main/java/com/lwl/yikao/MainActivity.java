package com.lwl.yikao;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.lwl.yikao.base.BaseLazyMainFragment;
import com.lwl.yikao.ui.fragment.MainFragment;

import me.yokeyword.fragmentation.SupportActivity;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by lwl on 2016/11/19.
 */
public class MainActivity extends SupportActivity implements BaseLazyMainFragment.OnBackToFirstListener {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                if (savedInstanceState == null) {
                        loadRootFragment(R.id.fl_container, MainFragment.newInstance());
                }
        }

        @Override
        public void onBackPressedSupport() {
                // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
                super.onBackPressedSupport();
        }

        @Override
        public FragmentAnimator onCreateFragmentAnimator() {
                // 设置横向(和安卓4.x动画相同)
                return new DefaultHorizontalAnimator();
        }

        @Override
        public void onBackToFirstFragment() {

        }
}