package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Question;

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

//    private void postMessage(final List<Product> products) {
//        mMainThread.post(new Runnable() {
//            @Override
//            public void run() {
//                mCallback.onProductRetrieved(products);
//            }
//        });
//    }

    private void postMessage(final List<Question> questions) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onQuestionRetrieved(questions);
            }
        });
    }

//    @Override
//    public void run() {
//
//        // retrieve the message
//        final List<Product> products = mProductRepository.getProducts();
//
//        // check if we have failed to retrieve our message
//        if (products == null || products.size() == 0) {
//
//            // notify the failure on the main thread
//            notifyError();
//
//            return;
//        }
//
//        // we have retrieved our message, notify the UI on the main thread
//        postMessage(products);
//    }

    @Override
    public void run() {

        // retrieve the message
        final List<Question> questions = mProductRepository.getQuestions();

        // check if we have failed to retrieve our message
        if (questions == null || questions.size() == 0) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage(questions);
    }
}
