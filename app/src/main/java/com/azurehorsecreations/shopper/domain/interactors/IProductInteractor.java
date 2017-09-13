package com.azurehorsecreations.shopper.domain.interactors;

import com.azurehorsecreations.shopper.domain.interactors.base.Interactor;
import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductInteractor extends Interactor {
    interface Callback {
        void onProductRetrieved(List<Product> products);
        void onRetrievalFailed(String error);
    }
}
