package com.test.amaro.amarotest.ui.activity.presenter;

import com.test.amaro.amarotest.entity.Product;

import java.util.List;

public interface MainActivityPresenter {
    void getFeed();

    interface View {
        //view methods
        void refreshProductList(List<Product> products);
        void goToTopOfList();
        void showErrorMessage();
    }
}
