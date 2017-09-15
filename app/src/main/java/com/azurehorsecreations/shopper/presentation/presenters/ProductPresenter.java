package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.Navigator;
import com.azurehorsecreations.shopper.presentation.presenters.base.BasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.BaseView;

import java.util.List;


public interface ProductPresenter extends BasePresenter {
    interface View extends BaseView {
        void displayProductInformation(List<Product> product);
    }
    void setNavigator(Navigator navigator);
    void navigateToNewScreen();
}
