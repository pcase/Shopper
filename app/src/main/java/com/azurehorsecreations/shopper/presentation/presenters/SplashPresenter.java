package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.presenters.base.BasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.BaseView;
import com.azurehorsecreations.shopper.presentation.ui.navigation.Navigator;

import java.util.List;


public interface SplashPresenter extends BasePresenter {
    void setNavigator(Navigator navigator);
    void navigateToNewScreen();
}
