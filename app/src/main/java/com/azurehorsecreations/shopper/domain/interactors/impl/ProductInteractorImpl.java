package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.IExecutor;
import com.azurehorsecreations.shopper.domain.executor.IMainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class ProductInteractorImpl extends AbstractInteractor implements IProductInteractor {

    private Callback mCallback;
    private ProductRepository mProductRepository;

    public ProductInteractorImpl(IExecutor threadExecutor,
                                 IMainThread mainThread,
                                 Callback callback, ProductRepository productRepository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mProductRepository = productRepository;
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("No results :(");
            }
        });
    }

    private void postMessage(final Product products) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onProductRetrieved(products);
            }
        });
    }

    @Override
    public void run() {
        Subscription mProductSubscription = mProductRepository.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Product>() {
                    @Override
                    public void onCompleted() {
                        ;
                    }

                    @Override
                    public void onError(Throwable e) {
                        notifyError();
                    }

                    @Override
                    public void onNext(Product products){
                        postMessage(products);
                    }
                });
//        IProductRepository.ProductRepositoryCallback callback = new IProductRepository.ProductRepositoryCallback() {
//            @Override
//            public void onProductRetrieved(Product products) {
//                postMessage(products);
//            }
//
//            @Override
//            public void onRetrievalFailed(String error) {
//                notifyError();
//            }
//        };
        mProductRepository.getProducts();
    }
}
