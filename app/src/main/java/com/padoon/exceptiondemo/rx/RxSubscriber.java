package com.padoon.exceptiondemo.rx;

import android.content.Context;

import com.padoon.exceptiondemo.MyApplication;
import com.padoon.exceptiondemo.api.exception.ApiError;
import com.padoon.exceptiondemo.api.exception.ApiErrorHelper;
import com.padoon.exceptiondemo.api.exception.ApiException;
import com.padoon.exceptiondemo.util.OSUtil;

import rx.Subscriber;

/**
 * Created by jiang on 2017/2/23.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    private Context mContext;

    public RxSubscriber() {
        mContext = MyApplication.getContext();
    }

    @Override
    public void onStart() {
        if (!OSUtil.hasInternet()) {
            this.onError(new ApiException(ApiError.ERROR_NET_CONNECTION.getErrorCode(), "ERROR_NET_CONNECTION"));
            return;
        }

    }

    @Override
    public void onError(Throwable e) {
        ApiErrorHelper.handleCommonError(mContext, e);
    }

    @Override
    public void onCompleted() {

    }
}
