package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.IExecutor;
import com.azurehorsecreations.shopper.domain.executor.IMainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        mProductRepository.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Product>() {

                    @Override
                    public void onError(Throwable e) {
                        notifyError();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(Product products){
                        postMessage(products);
                    }
                });
    }
}
