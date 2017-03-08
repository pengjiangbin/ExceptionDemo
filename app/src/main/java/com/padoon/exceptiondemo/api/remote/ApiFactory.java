package com.padoon.exceptiondemo.api.remote;


import com.padoon.exceptiondemo.SystemConst;
import com.padoon.exceptiondemo.api.client.ClientFactory;
import com.padoon.exceptiondemo.api.converter.CheckGsonConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by jiang on 2017/2/23.
 */

public class ApiFactory {
    private static ArticleApi mArticleApi;


    public static ArticleApi getArticleApi() {
        if (mArticleApi == null) {
            mArticleApi = createApi(SystemConst.BASE_URL_SAMPLE, ArticleApi.class);
        }
        return mArticleApi;
    }




    private static <T> T createApi(String baseUrl, Class<T> clazz) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(ClientFactory.getInstance().getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(CheckGsonConverterFactory.create());
        return builder.build().create(clazz);
    }
}
