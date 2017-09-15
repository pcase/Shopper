package com.azurehorsecreations.shopper.domain.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/*
 * Product class represents the product model
 */

public class Product_Not_Parcelable {
    private String productId;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private String price;
    private String productImage;
    private double reviewRating;
    private int reviewCount;
    private boolean inStock;
    private Bitmap productImageBitmap;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImageUrl) {
        this.productImage = productImageUrl;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Bitmap getProductImageBitmap() {
        return productImageBitmap;
    }

    public void setProductImageBitmap(Bitmap productImageBitmap) {
        this.productImageBitmap = productImageBitmap;
    }
}
