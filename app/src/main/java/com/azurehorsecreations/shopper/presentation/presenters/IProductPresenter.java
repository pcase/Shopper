package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.ui.navigation.INavigator;
import com.azurehorsecreations.shopper.presentation.presenters.base.IBasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.IBaseView;

import java.util.List;


public interface IProductPresenter extends IBasePresenter {
    interface View extends IBaseView {
        void displayProductInformation(List<Product> product);
    }
    void setNavigator(INavigator navigator);
    void navigateToNewScreen();
}
