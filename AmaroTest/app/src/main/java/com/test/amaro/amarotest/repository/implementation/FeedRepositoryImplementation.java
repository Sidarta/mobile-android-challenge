package com.test.amaro.amarotest.repository.implementation;

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
                } else {
                    onGetFeed.onGetFeedFailiure("Response not successful");
                    //log err
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                onGetFeed.onGetFeedFailiure("Call failed");
                //log failure
            }
        });
    }
}
