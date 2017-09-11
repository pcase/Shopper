package com.azurehorsecreations.shopper.data.network;

import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

/**
 * Created by pattycase on 9/8/17.
 */

public interface RestAPI {

    List<Product> getProducts();

}
