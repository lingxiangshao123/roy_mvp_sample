package com.wuxiaolong.androidmvpsample.ui;

import com.wuxiaolong.androidmvpsample.model.PositonBean;

/**
 * Created by WuXiaolong on 2015/9/23.
 * 处理业务需要哪些方法
 */
public interface PostionInterfaceActiviy {

    void showData(PositonBean positonBean);

    void showProgress();

    void hideProgress();

}
