package com.azurehorsecreations.photoalbum.domain.interactors;

import com.azurehorsecreations.photoalbum.domain.interactors.base.IInteractor;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IPhotoMetadataInteractor extends IInteractor {
    interface Callback {
        void onPhotoDetailRetrieved(List<PhotoMetadata> photos);
        void onRetrievalFailed(String error);
    }
}
