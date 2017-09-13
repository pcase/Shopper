package com.azurehorsecreations.shopper.domain.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/*
 * Product class represents the product model
 */

public class Product_Parcelable implements Parcelable {
    private String productId;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private String price;
    private String productImageUrl;
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

    public Bitmap getProductImage() {
        return productImageBitmap;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public void setProductImage(Bitmap productImage) {
        this.productImageBitmap = productImage;
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

    private Product_Parcelable(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        price = in.readString();
        productImageUrl = in.readString();
        productImageBitmap = in.readParcelable(Bitmap.class.getClassLoader());
        reviewRating = in.readDouble();
        reviewCount = in.readInt();
        inStock = in.readInt() == 1;
    }

    public Product_Parcelable() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(productId);
        out.writeString(productName);
        out.writeString(shortDescription);
        out.writeString(longDescription);
        out.writeString(price);
        out.writeString(productImageUrl);
        out.writeParcelable(getProductImageBitmap(), PARCELABLE_WRITE_RETURN_VALUE);
        out.writeDouble(reviewRating);
        out.writeInt(reviewCount);
        out.writeInt(inStock ? 1 : 0);
    }

    public static final Creator<Product_Parcelable> CREATOR
            = new Creator<Product_Parcelable>() {

        @Override
        public Product_Parcelable createFromParcel(Parcel in) {
            return new Product_Parcelable(in);
        }

        @Override
        public Product_Parcelable[] newArray(int size) {
            return new Product_Parcelable[size];
        }
    };
}
