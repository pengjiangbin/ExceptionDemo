package com.padoon.exceptiondemo.api.exception;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by jiang on 2017/2/23.
 */

public class ApiErrorHelper {
    public static void handleCommonError(Context context, Throwable e) {

        if (e instanceof HttpException || e instanceof IOException) {
            Toast.makeText(context, "网络错误", Toast.LENGTH_SHORT).show();
        } else {
            handleApiError(context, e);
        }

    }

    public static void handleApiError(Context context, Throwable e) {
        ApiException apiException = (ApiException) e;
        int errorCode = apiException.getErrorCode();
        Toast.makeText(context, ApiError.getErrorMessage(errorCode), Toast.LENGTH_SHORT).show();
    }
}

