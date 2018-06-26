package com.test.amaro.amarotest.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product implements Parcelable, Comparable<Product> {

    private String name;
    private int style;
    private String code_color;
    private String color_slug;
    private String color;

    @SerializedName("on_sale")
    private Boolean sale;

    private String regular_price;
    private String actual_price;
    private String discount_percentage;
    private String installments;
    private String image;
    private List<Size> sizes;

    public Product() {
    }

    public Product(String name, int style, String code_color, String color_slug, String color, Boolean sale, String regular_price, String actual_price, String discount_percentage, String installments, String image, List<Size> sizes) {
        this.name = name;
        this.style = style;
        this.code_color = code_color;
        this.color_slug = color_slug;
        this.color = color;
        this.sale = sale;
        this.regular_price = regular_price;
        this.actual_price = actual_price;
        this.discount_percentage = discount_percentage;
        this.installments = installments;
        this.image = image;
        this.sizes = sizes;
    }

    protected Product(Parcel in) {
        name = in.readString();
        style = in.readInt();
        code_color = in.readString();
        color_slug = in.readString();
        color = in.readString();
        byte tmpSale = in.readByte();
        sale = tmpSale == 0 ? null : tmpSale == 1;
        regular_price = in.readString();
        actual_price = in.readString();
        discount_percentage = in.readString();
        installments = in.readString();
        image = in.readString();

        sizes = new ArrayList<Size>();
        in.readTypedList(sizes, Size.CREATOR);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    //custom method
    //another option to get actual price - as float
    public float actualPriceAsFloat(){
        String onlyNumbers = this.actual_price.substring(3);
        return Float.parseFloat(onlyNumbers.replaceAll(",", "."));
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
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    /*
    Parcelable interface
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(style);
        dest.writeString(code_color);
        dest.writeString(color_slug);
        dest.writeString(color);
        dest.writeByte((byte) (sale == null ? 0 : sale ? 1 : 2));
        dest.writeString(regular_price);
        dest.writeString(actual_price);
        dest.writeString(discount_percentage);
        dest.writeString(installments);
        dest.writeString(image);
        dest.writeTypedList(sizes);
    }

    /*
    Comparable Interface - for ordering purposes
   */
    @Override
    public int compareTo(@NonNull Product product) {

        float priceFloatProd = product.actualPriceAsFloat();
        float priceFloatThis = this.actualPriceAsFloat();

        if((priceFloatThis - priceFloatProd) < 0)
            return -1;
        else
            return 1;
    }



}
