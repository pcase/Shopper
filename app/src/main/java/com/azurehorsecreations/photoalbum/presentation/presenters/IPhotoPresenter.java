package com.azurehorsecreations.photoalbum.presentation.presenters;

import com.azurehorsecreations.photoalbum.domain.model.Photo;
import com.azurehorsecreations.photoalbum.presentation.presenters.base.IBasePresenter;
import com.azurehorsecreations.photoalbum.presentation.ui.IBaseView;
import com.azurehorsecreations.photoalbum.presentation.ui.navigation.INavigator;

import java.util.List;


public interface IPhotoPresenter extends IBasePresenter {
    interface View extends IBaseView {
        void displayPhoto(List<Photo> photo);
    }
    void setNavigator(INavigator navigator);
    void navigateToNewScreen();
}
