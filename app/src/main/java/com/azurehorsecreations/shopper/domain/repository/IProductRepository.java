package com.azurehorsecreations.shopper.domain.repository;

import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductRepository {
    List<Product> getProducts();
}
