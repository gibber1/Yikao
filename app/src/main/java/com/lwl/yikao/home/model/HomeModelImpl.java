package com.lwl.yikao.home.model;


import com.lwl.yikao.R;
import com.lwl.yikao.bean.home;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l_wl on 2016/6/5.
 */
public class HomeModelImpl implements HomeModel {


    @Override
    public void loaddata(OnLoadDataListListener listener) {

        String[] mTitles = new String[]{
                "超美艳的18位古装新娘：朱茵、唐嫣、赵丽颖、佟丽娅等",
                "盘点娱乐圈女星，你肯定想不到还有她",
                "娱圈中原配与情人相处无事的明星们，原来大傻一点都不傻",
                "娱乐圈十大演技好、绯闻绝缘体女星，无视潜规则难上位",
                "他是中国最牛X主持,是龙年春晚主持第七人"
        };

        int[] mImgRes = new int[]{
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_1, R.drawable.img_1, R.drawable.img_2
        };

        // Init Datas
        List<home> homeList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int index = i % 5;
            home article = new home(mTitles[index], "2016-11-20","为祝贺公司正式上市，全体员工加工资100元!",mImgRes[index]);
            homeList.add(article);
        }

        listener.onSuccess(homeList);

    }

    public interface OnLoadDataListListener {
        void onSuccess(List<home> list);

        void onFailure(String msg, Exception e);
    }

}
