package com.azurehorsecreations.shopper.data.network;

import com.azurehorsecreations.shopper.domain.model.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pattycase on 9/9/17.
 */

public interface ProductAPIService {
    @GET("/_ah/api/walmart/v1/walmartproducts/e0a4274f-45b6-405b-839e-1096222be4fc/{page}/30")  //End Url
    Call<ProductList> fetchProducts(@Path("page") int page);
}
