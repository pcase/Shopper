package com.azurehorsecreations.shopper.domain.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/*
 * Product class represents the product model
 */

public class ProductResponse {
    public String productId;
    public String productName;
    public String shortDescription;
    public String longDescription;
    public String price;
    public String productImage;
    public double reviewRating;
    public int reviewCount;
    public boolean inStock;
    public Bitmap productImageBitmap;

    public ProductResponse(String productId, String productName, String shortDescription, String longDescription, String price, String productImage, double reviewRating, int reviewCount, boolean inStock, Bitmap productImageBitmap) {
        this.productId = productId;
        this.productName = productName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
        this.productImage = productImage;
        this.productImageBitmap = productImageBitmap;
        this.reviewRating = reviewRating;
        this.reviewCount = reviewCount;
        this.inStock = inStock;
    }
}
