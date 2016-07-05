package com.wuxiaolong.androidmvpsample.model;

import com.wuxiaolong.androidmvpsample.model.PositonBean;

/**
 * Created by WuXiaolong on 2015/9/23.
 * 此接口作用是连接Model
 */
public interface PostionInterfaceControl {

    void loadDataSuccess(PositonBean positonBean);

    void loadDataFailure();
}


