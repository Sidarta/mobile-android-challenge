package com.test.amaro.amarotest.entity;

public class Size {
    private Boolean avaliable;
    private String size;
    private String sku;

    public Size(){}

    public Size(Boolean avaliable, String size, String sku) {
        this.avaliable = avaliable;
        this.size = size;
        this.sku = sku;
    }

    public Boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        this.avaliable = avaliable;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
