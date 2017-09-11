package com.azurehorsecreations.shopper.domain.interactors;

import com.azurehorsecreations.shopper.domain.interactors.base.Interactor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product2;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductInteractor extends Interactor {
    interface Callback {
        void onProductRetrieved(List<Product2> products);

        void onRetrievalFailed(String error);
    }
}
