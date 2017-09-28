package com.azurehorsecreations.photoalbum.domain.model;

/**
 * Created by pattycase on 9/27/17.
 */

public class Photo {
    private PhotoMetadata metadata;

    public PhotoMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(PhotoMetadata metadata) {
        this.metadata = metadata;
    }
    private String photo_image_url;

    public String getPhoto_title() {
        return photo_title;
    }

    public void setPhoto_title(String photo_title) {
        this.photo_title = photo_title;
    }

    private String photo_title;

    public String getPhoto_image_url() {
        return photo_image_url;
    }

    public void setPhoto_image_url(String photo_image_url) {
        this.photo_image_url = photo_image_url;
    }
}
