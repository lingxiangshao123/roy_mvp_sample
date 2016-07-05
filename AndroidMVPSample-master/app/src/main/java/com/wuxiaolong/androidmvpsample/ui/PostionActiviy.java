package com.wuxiaolong.androidmvpsample.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wuxiaolong.androidmvpsample.R;
import com.wuxiaolong.androidmvpsample.model.PositonBean;
import com.wuxiaolong.androidmvpsample.presenter.PostionPresenter;

/**
 * Created by WuXiaolong on 2015/9/23.
 * 由Activity/Fragment实现View里方法，包含一个Presenter的引用
 */
public class PostionActiviy extends AppCompatActivity implements PostionInterfaceActiviy {
    private ProgressBar mProgressBar;
    private TextView text;
    private PostionPresenter mPostionPresenter;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        text = (TextView) findViewById(R.id.text);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mPostionPresenter = new PostionPresenter(this);
        //制造延迟效果
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPostionPresenter.loadData();
            }
        }, 2000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mPostionPresenter.detachView();
    }

    @Override
    public void showData(PositonBean positonBean) {
        String showData = getResources().getString(R.string.city) + positonBean.getCity()
                + getResources().getString(R.string.wd) + positonBean.getWd()
                + getResources().getString(R.string.ws) + positonBean.getWs()
                + getResources().getString(R.string.time) + positonBean.getTime();
        text.setText(showData);
    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }


}
