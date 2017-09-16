package com.azurehorsecreations.shopper.domain.repository;

import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductRepository {
    interface ProductRepositoryCallback {
        void onProductRetrieved(List<Product> products);
        void onRetrievalFailed(String error);
    }
    void getProducts(ProductRepositoryCallback callback);
}
