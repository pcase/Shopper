package com.azurehorsecreations.shopper.data.network;

import android.util.Log;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by pattycase on 9/18/17.
 */

public class RestClientSingleton {
    private static final String BASE_URL = "https://walmartlabs-test.appspot.com";
    private static RestClientSingleton instance;
    private IProductAPIService apiService;

    private RestClientSingleton() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(IProductAPIService.class);
        Log.d("RestClientSingleton", "constructor");
    }

    public static RestClientSingleton getInstance() {
        if (instance == null) {
            instance = new RestClientSingleton();
        }
        return instance;
    }

    public Observable<ProductResponse> getProducts(int page) {
        return apiService.fetchProducts(page);
    }
}
