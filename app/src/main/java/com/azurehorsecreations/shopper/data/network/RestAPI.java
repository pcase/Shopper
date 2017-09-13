package com.azurehorsecreations.shopper.data.network;

import com.azurehorsecreations.shopper.domain.model.Product_Parcelable;

import java.util.List;

/**
 * Created by pattycase on 9/8/17.
 */

public interface RestAPI {

    List<Product_Parcelable> getProducts();

}
