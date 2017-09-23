package com.azurehorsecreations.shopper.data.repository;

import android.util.Log;

import com.azurehorsecreations.shopper.data.network.IProductAPIService;


import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;

/**
 * Created by pattycase on 9/9/17.
 */

public class ProductRepository implements IProductRepository, Callback<Product> {
    private static String TAG = "ProductRepository";
    private IProductAPIService apiService;
    private List<Product> productList;
    private int page = 1;
    Subscription subscription;
    ProductRepositoryCallback callback;

//    public void getProducts(final ProductRepositoryCallback callback) {
//        this.callback = callback;
//        Call<Product> call = RestClientSingleton.getInstance().getProducts(page++);
//        call.enqueue(this);
//    }
//
    @Override
    public void onResponse(Call<Product> call, Response<Product> response) {
        callback.onProductRetrieved(response.body());
    }

    @Override
    public void onFailure(Call<Product> call, Throwable t) {
        callback.onRetrievalFailed(t.getLocalizedMessage());
    }
//
//        subscription = RestClientSingleton.getInstance()
//                .getProducts(page++)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Product>>() {
//                    @Override public void onCompleted() {
//                        Log.d(TAG, "In onCompleted()");
//                    }
//
//                    @Override public void onError(Throwable e) {
//                        Log.d(TAG, "In onError()" + e.getLocalizedMessage());
//                        callback.onRetrievalFailed(e.getMessage());
//                    }
//
//                    @Override public void onNext(List<Product> products) {
//                        Log.d(TAG, "In onNext()");
//                        doSomething();
//                        callback.onProductRetrieved(products);
//                    }
//                });
//    }


//        apiService = RestClient.getClient().create(IProductAPIService.class);
//        Single<Observable<List<Product>>> tvShowSingle = Single.fromCallable(new Callable<Observable<List<Product>>>() {
//            @Override
//            public Observable<List<Product>> call() throws Exception {
//                return apiService.fetchProducts(1);
//            }
//        });

//    @Override
//    public Observable<Product> getProducts() {
//        IProductAPIService apiService = RestClient.getClient().create(IProductAPIService.class);
//        return apiService.fetchProducts(page++);
//    }

//@Override
//public void getProducts(final ProductRepositoryCallback callback) {
//    subscription = RestClientSingleton.getInstance()
//            .getProducts(page++)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Observer<Product>() {
//                @Override
//                public void onCompleted() {
//                    Log.d(TAG, "In onCompleted()");
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "In onError()");
//                }
//
//                @Override
//                public void onNext(Product product) {
//                    Log.d(TAG, "In onNext()");
//                }
//            });
//}

//    @Override
//    public void getProducts(final ProductRepositoryCallback callback) {
//        apiService = RestClient.getClient().create(IProductAPIService.class);
//        Call<Product> call = apiService.fetchProducts(page++);
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                Log.d(TAG, "Total number Product products fetched : " + 1);
//                callback.onProductRetrieved(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                Log.e(TAG, "Got error : " + t.getLocalizedMessage());
//                callback.onRetrievalFailed("Got error : " + t.getLocalizedMessage());
//            }
//        });
//    }

//    @Override
//    public void getProducts(final ProductRepositoryCallback callback) {
//        apiService = RestClient.getClient().create(IProductAPIService.class);
//        Call<Product> call = apiService.fetchProducts(page++);
//        call.enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, final Response<Product> response) {
//                Log.d(TAG, "Total number Product products fetched : " + 1);
//                callback.onProductRetrieved(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                Log.e(TAG, "Got error : " + t.getLocalizedMessage());
//                callback.onRetrievalFailed("Got error : " + t.getLocalizedMessage());
//            }
//        });
//    }

    @Override
    public Observable<Product> getProducts() {
        return Observable.fromCallable(() -> {
            Product product = new Product();
            product.setProductName("Samsung");
            product.setProductId("1234");
            product.setPrice("799.00");
            return product;
        });
//        Observable.fromCallable(() -> apiService.fetchProducts(page++))
//                .flatMap(userId -> {
//                    List<Product> products = fetchFriends(userId);
//                    return Observable.fromIterable(signedUpFriends);
//                })
//                .flatMap(signedUpFriend -> {
//                    //here we iterate through the whole list
//                   ...
//                })
    }
}