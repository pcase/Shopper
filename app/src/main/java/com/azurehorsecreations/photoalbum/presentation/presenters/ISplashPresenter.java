package com.azurehorsecreations.photoalbum.presentation.presenters;

import com.azurehorsecreations.photoalbum.presentation.presenters.base.IBasePresenter;
import com.azurehorsecreations.photoalbum.presentation.ui.navigation.INavigator;


public interface ISplashPresenter extends IBasePresenter {
    void setNavigator(INavigator navigator);
    void navigateToNewScreen();
}
