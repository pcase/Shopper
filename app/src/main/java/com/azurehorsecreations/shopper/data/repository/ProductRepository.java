package com.azurehorsecreations.shopper.data.repository;

import android.util.Log;

import com.azurehorsecreations.shopper.data.network.ProductAPIService;
import com.azurehorsecreations.shopper.data.network.ProductInformationFetcherHandler;
import com.azurehorsecreations.shopper.data.network.RestClient;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product2;
import com.azurehorsecreations.shopper.domain.model.ProductList;
import com.azurehorsecreations.shopper.domain.model.QuestionList;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;
import com.azurehorsecreations.shopper.utils.CallbackReceiver;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pattycase on 9/9/17.
 */

public class ProductRepository implements IProductRepository {

    private ProductAPIService apiService;
    private List<Product2> productList;

    @Override
    public List<Product2> getProducts() {
        Log.d("", "ProductRepository.getProducts()");
        apiService = RestClient.getClient().create(ProductAPIService.class);
        fetchProductList();
        return null;
    }

    private void fetchProductList() {
        Log.d("", "ProductRepository.fetchProductList()");
        Call<ProductList> call = apiService.fetchProducts();
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                Log.d("", "Total number of products fetched : " + response.body().getProducts().size());
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.e("", "Got error : " + t.getLocalizedMessage());
            }
        });
    }
}
