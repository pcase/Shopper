package com.azurehorsecreations.shopper.presentation.presenters.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.impl.ProductInteractorImpl;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.presenters.base.AbstractPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.MainPresenter;

import java.util.List;

/**
 * Created by dmilicic on 12/13/15.
 */
public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        IProductInteractor.Callback {

    private MainPresenter.View mView;
    private ProductRepository mProductRepository;

    public MainPresenterImpl(Executor executor, MainThread mainThread,
                             View view, ProductRepository productRepository) {
        super(executor, mainThread);
        mView = view;
        mProductRepository = productRepository;
    }

    @Override
    public void resume() {

        mView.showProgress();

        IProductInteractor interactor = new ProductInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mProductRepository
        );

        interactor.execute();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {
        mView.showError(message);
    }

    @Override
    public void onProductRetrieved(List<Product> products) {
        mView.hideProgress();
        mView.displayProductInformation(products);
    }

    @Override
    public void onRetrievalFailed(String error) {
        mView.hideProgress();
        onError(error);
    }
}
