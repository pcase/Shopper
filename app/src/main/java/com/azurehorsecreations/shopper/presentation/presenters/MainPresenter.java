package com.azurehorsecreations.shopper.presentation.presenters;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Question;
import com.azurehorsecreations.shopper.presentation.presenters.base.BasePresenter;
import com.azurehorsecreations.shopper.presentation.ui.BaseView;

import java.util.List;


public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void displayWelcomeMessage(String msg);

        void displayQuestionInformation(List<Question> question);
        void displayProductInformation(List<Product> product);
    }

}
