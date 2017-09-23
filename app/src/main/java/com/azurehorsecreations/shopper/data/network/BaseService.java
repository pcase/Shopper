package com.azurehorsecreations.shopper.data.network;

import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

import rx.Observable;

/**
 * Created by pattycase on 9/17/17.
 */

public interface BaseService {
    Observable<List<Product>> fetchProducts();
}
