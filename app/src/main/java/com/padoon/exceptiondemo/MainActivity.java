package com.padoon.exceptiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.padoon.exceptiondemo.api.remote.ApiFactory;
import com.padoon.exceptiondemo.data.ArticleList;
import com.padoon.exceptiondemo.data.HttpResult;
import com.padoon.exceptiondemo.rx.RxSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_test = (Button) findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiFactory.getArticleApi().getArticleList(1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscriber<HttpResult<ArticleList>>() {
                            @Override
                            public void onNext(HttpResult<ArticleList> articleListHttpResult) {
                                Log.d(TAG, "onNext: "+articleListHttpResult);
                            }
                        });
            }
        });
    }
}
