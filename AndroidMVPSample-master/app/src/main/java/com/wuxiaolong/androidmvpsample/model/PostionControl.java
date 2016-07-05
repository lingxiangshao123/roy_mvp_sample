package com.wuxiaolong.androidmvpsample.model;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by WuXiaolong on 2015/9/23.
 * 业务具体处理，包括负责存储、检索、操纵数据等
 */
public class PostionControl {

    private PostionInterfaceControl mPostionInterfaceControl;

    public PostionControl(PostionInterfaceControl postionInterfaceControl) {
        this.mPostionInterfaceControl = postionInterfaceControl;
    }

    public void loadData() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("http://www.weather.com.cn/adat/sk/101010100.html", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    PositonBean positonBean = new PositonBean();
                    JSONObject weatherinfo = response.getJSONObject("weatherinfo");
                    positonBean.setCity(weatherinfo.getString("city"));
                    positonBean.setWd(weatherinfo.getString("WD"));
                    positonBean.setWs(weatherinfo.getString("WS"));
                    positonBean.setTime(weatherinfo.getString("time"));
                    mPostionInterfaceControl.loadDataSuccess(positonBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                mPostionInterfaceControl.loadDataFailure();
            }
        });
    }


}
