package com.padoon.exceptiondemo.api.client;


import com.padoon.exceptiondemo.BuildConfig;
import com.padoon.exceptiondemo.SystemConst;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by jiang on 2017/2/23.
 */

public class ClientFactory {
    private OkHttpClient mOkHttpClient;
    private OkHttpClient.Builder mBuilder;
    private static final long CONNECTION_TIMEOUT = 15;
    private static final long READ_TIMEOUT = 10;

    private ClientFactory() {
        mBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            mBuilder.addInterceptor(ClientHelper.getLoggingInterceptor());
        }
        Cache cache = new Cache(new File(SystemConst.PATH_CACHE), 10 * 1024 * 1024);
        mBuilder.retryOnConnectionFailure(true)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .addNetworkInterceptor(ClientHelper.getCacheInterceptor())
                .addInterceptor(ClientHelper.getCacheInterceptor());
    }

    private static class SingleHolder {
        private static ClientFactory INSTANCE = new ClientFactory();
    }

    public static ClientFactory getInstance() {
        return SingleHolder.INSTANCE;
    }

    public OkHttpClient getOkHttpClient() {
        mOkHttpClient = mBuilder.build();
        return mOkHttpClient;
    }

}
