package com.test.amaro.amarotest.callback;

import com.test.amaro.amarotest.entity.Product;

import java.util.List;

public interface OnGetFeed {

    void onGetFeedSuccessful(List<Product> products);
    void onGetFeedFailiure(String errorMessage);

}
