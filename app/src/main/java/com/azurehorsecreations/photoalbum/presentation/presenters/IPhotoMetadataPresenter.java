package com.azurehorsecreations.photoalbum.presentation.presenters;

import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;
import com.azurehorsecreations.photoalbum.presentation.ui.navigation.INavigator;
import com.azurehorsecreations.photoalbum.presentation.presenters.base.IBasePresenter;
import com.azurehorsecreations.photoalbum.presentation.ui.IBaseView;

import java.util.List;


public interface IPhotoMetadataPresenter extends IBasePresenter {
    interface View extends IBaseView {
        void displayPhotoInformation(List<PhotoMetadata> photo);
    }
    void setNavigator(INavigator navigator);
    void navigateToNewScreen();
}
