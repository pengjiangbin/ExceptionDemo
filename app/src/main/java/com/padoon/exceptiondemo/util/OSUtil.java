package com.padoon.exceptiondemo.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.padoon.exceptiondemo.MyApplication;

/**
 * Created by jiang on 2017/2/23.
 */

public class OSUtil {
    public static boolean hasInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected = connectivityManager.getActiveNetworkInfo() != null;
        return isConnected;
    }
}
