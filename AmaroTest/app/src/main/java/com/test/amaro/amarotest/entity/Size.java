package com.test.amaro.amarotest.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Size implements Parcelable{
    private boolean available;
    private String size;
    private String sku;

    public Size(){}

    public Size(boolean available, String size, String sku) {
        this.available = available;
        this.size = size;
        this.sku = sku;
    }

    protected Size(Parcel in) {
        available = in.readByte() != 0;
        size = in.readString();
        sku = in.readString();
    }

    public static final Creator<Size> CREATOR = new Creator<Size>() {
        @Override
        public Size createFromParcel(Parcel in) {
            return new Size(in);
        }

        @Override
        public Size[] newArray(int size) {
            return new Size[size];
        }
    };

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeString(size);
        dest.writeString(sku);
    }
}
