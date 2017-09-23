package com.azurehorsecreations.shopper.domain.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 * Product class represents the product model
 */

public class ProductResponse {
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("products")
    public List<Product> products;
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
