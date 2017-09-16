package com.azurehorsecreations.shopper.data.repository;

import android.util.Log;

import com.azurehorsecreations.shopper.data.network.ProductAPIService;
import com.azurehorsecreations.shopper.data.network.RestClient;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductList;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pattycase on 9/9/17.
 */

public class ProductRepository implements IProductRepository {

    private ProductAPIService apiService;
    private List<Product> productList;
    private int page = 1;

    @Override
    public void getProducts(final ProductRepositoryCallback callback) {
        apiService = RestClient.getClient().create(ProductAPIService.class);
        Call<ProductList> call = apiService.fetchProducts(page++);
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                Log.d("", "Total number of products fetched : " + response.body().getProducts().size());
                productList = response.body().getProducts();
                callback.onProductRetrieved(productList);
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.e("", "Got error : " + t.getLocalizedMessage());
                callback.onRetrievalFailed("Got error : " + t.getLocalizedMessage());
            }
        });
    }
}
