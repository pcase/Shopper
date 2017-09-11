package com.azurehorsecreations.shopper.domain.repository;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product2;

import java.util.List;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductRepository {
    List<Product2> getProducts();
}
