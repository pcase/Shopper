package com.azurehorsecreations.shopper.data.network;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductList;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by pattycase on 9/9/17.
 */

public interface IProductAPIService {

//    @GET("/_ah/api/walmart/v1/walmartproducts/e0a4274f-45b6-405b-839e-1096222be4fc/{page}/30")
//    Call<Product> fetchProducts(@Path("page") int page);

//    @GET("/_ah/api/walmart/v1/walmartproducts/e0a4274f-45b6-405b-839e-1096222be4fc/{page}/30")
//    Observable<List<Product>> fetchProducts(@Path("page") int page);

    @GET("/_ah/api/walmart/v1/walmartproducts/e0a4274f-45b6-405b-839e-1096222be4fc/{page}/30")
    Observable<ProductResponse> fetchProducts(@Path("page") int page);
}
