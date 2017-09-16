package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.presentation.presenters.base.IBasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.navigation.INavigator;


public interface ISplashPresenter extends IBasePresenter {
    void setNavigator(INavigator navigator);
    void navigateToNewScreen();
}
