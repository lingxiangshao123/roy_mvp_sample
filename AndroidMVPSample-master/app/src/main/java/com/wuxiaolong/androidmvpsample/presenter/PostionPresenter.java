package com.wuxiaolong.androidmvpsample.presenter;

import com.wuxiaolong.androidmvpsample.model.PostionControl;
import com.wuxiaolong.androidmvpsample.model.PositonBean;
import com.wuxiaolong.androidmvpsample.model.PostionInterfaceControl;
import com.wuxiaolong.androidmvpsample.ui.PostionInterfaceActiviy;

/**
 * Created by WuXiaolong on 2015/9/23.
 * View和Model的桥梁，它从Model层检索数据后，返回给View层
 */
public class PostionPresenter implements PostionInterfaceControl {
    private PostionInterfaceActiviy mPostionInterfaceActiviy;
    private PostionControl mPostionControl;

    public PostionPresenter(PostionInterfaceActiviy view) {
        this.mPostionInterfaceActiviy = view;
        mPostionControl = new PostionControl(this);
    }

    public void detachView() {
        this.mPostionInterfaceActiviy = null;
    }

    public void loadData() {
        mPostionInterfaceActiviy.showProgress();
        mPostionControl.loadData();
    }


    @Override
    public void loadDataSuccess(PositonBean positonBean) {
        mPostionInterfaceActiviy.showData(positonBean);
        mPostionInterfaceActiviy.hideProgress();
    }

    @Override
    public void loadDataFailure() {
        mPostionInterfaceActiviy.hideProgress();
    }


}
