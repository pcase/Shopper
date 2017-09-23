package com.azurehorsecreations.shopper.domain.interactors;

import com.azurehorsecreations.shopper.domain.interactors.base.IInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductResponse;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductInteractor extends IInteractor {
    interface Callback {
        void onProductRetrieved(ProductResponse products);
        void onRetrievalFailed(String error);
    }
}
