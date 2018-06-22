package com.test.amaro.amarotest.entity;

import java.util.List;

/**
 * Feed could have other fields like timestamp, pagination, and other features to work with list of products
 * For this test, because we are only getting the whole list, we are working only with a list of products here
 */
public class Feed {

    private List<Product> products;

    public Feed() {
    }

    public Feed(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
