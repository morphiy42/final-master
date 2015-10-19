package com.example.myapplication3.app.rest;

import com.example.myapplication3.app.workers.Constants;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by omar on 9/22/15.
 */
public abstract class RetrofitAdapter {



    private static RetrofitInterface retrofitInterface;
    private static RestAdapter restAdapter;

    public static RetrofitInterface getInterface() {

        if (retrofitInterface == null) {
            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(10, TimeUnit.SECONDS); // connect timeout
            client.setReadTimeout(10, TimeUnit.SECONDS);

            restAdapter = new RestAdapter.Builder().setEndpoint(Constants.SERVER_URL).setClient(new OkClient
                    (client)).build();
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            retrofitInterface = restAdapter.create(RetrofitInterface.class);
        }
        return retrofitInterface;
    }

}