package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product2;
import com.azurehorsecreations.shopper.presentation.presenters.base.BasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.BaseView;

import java.util.List;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void displayWelcomeMessage(String msg);
        void displayProductInformation(List<Product2> product);
    }

}
