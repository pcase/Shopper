package com.azurehorsecreations.photoalbum.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/*
 * Photo class represents the photo model
 */

public class PhotoMetadata implements Parcelable {
    public PhotoMetadata() {}

    public PhotoMetadata(Parcel in) {
        title = in.readString();
        description = in.readString();
        filename = in.readString();
    }

    public static final Creator<PhotoMetadata> CREATOR = new Creator<PhotoMetadata>() {
        @Override
        public PhotoMetadata createFromParcel(Parcel in) {
            return new PhotoMetadata(in);
        }

        @Override
        public PhotoMetadata[] newArray(int size) {
            return new PhotoMetadata[size];
        }
    };

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("filename")
    public String filename;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(filename);
    }
}
