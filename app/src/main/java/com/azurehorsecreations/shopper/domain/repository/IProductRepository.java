package com.azurehorsecreations.shopper.domain.repository;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

import rx.Observable;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductRepository {
    interface ProductRepositoryCallback {
        void onProductRetrieved(Product products);
        void onRetrievalFailed(String error);
    }
    Observable<Product> getProducts();
}
