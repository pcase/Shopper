package com.azurehorsecreations.shopper.domain.repository;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductRepository {
    Observable<Product> getProducts();
}
