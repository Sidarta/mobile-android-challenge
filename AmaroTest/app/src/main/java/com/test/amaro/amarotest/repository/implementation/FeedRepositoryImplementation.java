package com.test.amaro.amarotest.repository.implementation;

import android.util.Log;

import com.test.amaro.amarotest.api.AmaroApi;
import com.test.amaro.amarotest.api.AmaroApiClient;
import com.test.amaro.amarotest.callback.OnGetFeed;
import com.test.amaro.amarotest.entity.Feed;
import com.test.amaro.amarotest.entity.Product;
import com.test.amaro.amarotest.repository.FeedRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedRepositoryImplementation implements FeedRepository{

    private AmaroApi service;

    public FeedRepositoryImplementation() {
        AmaroApiClient amaroApiClient = new AmaroApiClient();
        service = amaroApiClient.getClient().create(AmaroApi.class);
    }

    @Override
    public void getFeed(final OnGetFeed onGetFeed) {
        service.getFeed().enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response.isSuccessful()){
                    List<Product> products = response.body().getProducts();
                    onGetFeed.onGetFeedSuccessful(products);
                    //log success
                    Log.d("Repository", "get feed on success");
                } else {
                    onGetFeed.onGetFeedFailiure("Response not successful"); //TODO strings
                    //log err
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                onGetFeed.onGetFeedFailiure("Call failed"); //TODO strings
                //log failure
                Log.d("Repository", "get feed on failure");
            }
        });
    }
}
