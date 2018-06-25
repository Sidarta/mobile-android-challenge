package com.test.amaro.amarotest.entity;

import java.util.List;


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

//TODO instead of whole list, we could use pagination - need API for that