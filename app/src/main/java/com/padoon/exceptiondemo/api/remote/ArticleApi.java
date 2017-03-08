package com.padoon.exceptiondemo.api.remote;

import com.padoon.exceptiondemo.data.ArticleList;
import com.padoon.exceptiondemo.data.HttpResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jiang on 2017/3/8.
 */

public interface ArticleApi {
    @GET("android/article")
    Observable<HttpResult<ArticleList>> getArticleList(@Query("page") int page);
}
