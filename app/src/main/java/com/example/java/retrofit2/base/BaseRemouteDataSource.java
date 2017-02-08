package com.example.java.retrofit2.base;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by java on 08.02.2017.
 */

public abstract class BaseRemouteDataSource implements BaseDataSource {
    private static final String NEWS_ENDPOINT = "https://api.github.com/";
    protected ReposService repoService = null;

    @Override
    public void init(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NEWS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        //return retrofit.create(NewsApiInterface.class);
        repoService = retrofit.create(ReposService.class);
    }
}
