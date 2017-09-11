package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.WelcomingInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Product2;
import com.azurehorsecreations.shopper.domain.repository.MessageRepository;

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
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final List<Product2> products) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onProductRetrieved(products);
            }
        });
    }

    @Override
    public void run() {

        // retrieve the message
        final List<Product2> products = mProductRepository.getProducts();

        // check if we have failed to retrieve our message
        if (products == null || products.size() == 0) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage(products);
    }
}
