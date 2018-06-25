package com.test.amaro.amarotest.ui.adapter.presenter;

import com.test.amaro.amarotest.entity.Product;

import java.util.List;

public interface FeedAdapterPresenter {

    //Logic for the adapter goes here

    //----

    //interface for UI methods
    interface View {
        void updateFeed(List<Product> products);
    }
}
