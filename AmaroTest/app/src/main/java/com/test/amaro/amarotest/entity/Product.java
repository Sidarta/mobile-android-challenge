package com.test.amaro.amarotest.entity;

public class Product {

    private String name;
    private int style;
    private String code_color;
    private String color_slug;
    private String Color;
    private Boolean sale;
    private String regular_price;
    private String actual_price;
    private String discount_percentage;
    private String installments;
    private String image;

    public Product() {
    }

    public Product(String name, int style, String code_color, String color_slug, String color, Boolean sale, String regular_price, String actual_price, String discount_percentage, String installments, String image) {
        this.name = name;
        this.style = style;
        this.code_color = code_color;
        this.color_slug = color_slug;
        Color = color;
        this.sale = sale;
        this.regular_price = regular_price;
        this.actual_price = actual_price;
        this.discount_percentage = discount_percentage;
        this.installments = installments;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getCode_color() {
        return code_color;
    }

    public void setCode_color(String code_color) {
        this.code_color = code_color;
    }

    public String getColor_slug() {
        return color_slug;
    }

    public void setColor_slug(String color_slug) {
        this.color_slug = color_slug;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
