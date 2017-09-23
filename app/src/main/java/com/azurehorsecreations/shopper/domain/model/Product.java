package com.azurehorsecreations.shopper.domain.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Product class represents the product model
 */

public class Product implements Parcelable {
    @SerializedName("productId")
    public String productId;
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @SerializedName("productName")
    public String productName;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @SerializedName("shortDescription")
    public String shortDescription;
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @SerializedName("longDescription")
    public String longDescription;
    public String getLongDescription() {
        return longDescription;
    }
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @SerializedName("price")
    public String price;
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @SerializedName("productImage")
    public String productImage;
    public String getProductImage() {
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @SerializedName("reviewRating")
    public double reviewRating;
    public double getReviewRating() {
        return reviewRating;
    }
    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    @SerializedName("reviewCount")
    public int reviewCount;
    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @SerializedName("inStock")
    public boolean inStock;
    public boolean isInStock() {
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @SerializedName("productImageBitmap")
    public Bitmap productImageBitmap;
    public Bitmap getProductImageBitmap() {
        return productImageBitmap;
    }
    public void setProductImageBitmap(Bitmap productImageBitmap) {
        this.productImageBitmap = productImageBitmap;
    }

    private Product(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        shortDescription = in.readString();
        longDescription = in.readString();
        price = in.readString();
        productImage = in.readString();
        productImageBitmap = in.readParcelable(Bitmap.class.getClassLoader());
        reviewRating = in.readDouble();
        reviewCount = in.readInt();
        inStock = in.readInt() == 1;
    }

    public Product() {
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
        out.writeString(productImage);
        out.writeParcelable(getProductImageBitmap(), PARCELABLE_WRITE_RETURN_VALUE);
        out.writeDouble(reviewRating);
        out.writeInt(reviewCount);
        out.writeInt(inStock ? 1 : 0);
    }

    public static final Creator<Product> CREATOR
            = new Creator<Product>() {

        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
