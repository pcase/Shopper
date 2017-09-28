package com.azurehorsecreations.photoalbum.domain.repository;

import android.graphics.Bitmap;

import com.azurehorsecreations.photoalbum.domain.model.Photo;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IPhotoRepository {
    Observable<List<PhotoMetadata>> getPhotoMetadata();
}
