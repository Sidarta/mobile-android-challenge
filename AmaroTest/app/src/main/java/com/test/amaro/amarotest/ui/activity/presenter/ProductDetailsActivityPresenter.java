package com.test.amaro.amarotest.ui.activity.presenter;

import com.test.amaro.amarotest.entity.Product;

public interface ProductDetailsActivityPresenter {

    interface View {
        void displayProduct(Product product);
    }

}
