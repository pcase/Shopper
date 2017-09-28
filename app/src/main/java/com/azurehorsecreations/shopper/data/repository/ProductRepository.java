package com.azurehorsecreations.shopper.data.repository;

import com.azurehorsecreations.shopper.data.network.IProductAPIService;


import com.azurehorsecreations.shopper.data.network.RestClientSingleton;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductResponse;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pattycase on 9/9/17.
 */

public class ProductRepository implements IProductRepository {
    private static String TAG = "ProductRepository";
    private ProductResponse productList;
    private int page = 1;

    @Override
    public Observable<ProductResponse> getProducts() {
        return Observable.defer(() -> RestClientSingleton.getInstance().getProducts(page++));
    }
}