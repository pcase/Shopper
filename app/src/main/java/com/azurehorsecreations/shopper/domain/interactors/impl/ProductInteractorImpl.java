package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;

import java.util.List;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class ProductInteractorImpl extends AbstractInteractor implements IProductInteractor {

    private Callback mCallback;
    private ProductRepository mProductRepository;

    public ProductInteractorImpl(Executor threadExecutor,
                                 MainThread mainThread,
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

    private void postMessage(final List<Product> products) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onProductRetrieved(products);
            }
        });
    }

    @Override
    public void run() {
        final List<Product> products = mProductRepository.getProducts();

        if (products == null || products.size() == 0) {
            notifyError();
            return;
        }

        postMessage(products);
    }
}
