package com.azurehorsecreations.shopper.presentation.presenters.impl;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.IExecutor;
import com.azurehorsecreations.shopper.domain.executor.IMainThread;
import com.azurehorsecreations.shopper.domain.interactors.IProductInteractor;
import com.azurehorsecreations.shopper.domain.interactors.impl.ProductInteractorImpl;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.ui.navigation.INavigator;
import com.azurehorsecreations.shopper.presentation.presenters.base.AbstractPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.IProductPresenter;

import java.util.List;

/**
 * Created by dmilicic on 12/13/15.
 */
public class ProductPresenterImpl extends AbstractPresenter implements IProductPresenter,
        IProductInteractor.Callback {

    private IProductPresenter.View mView;
    private ProductRepository mProductRepository;
    private INavigator mNavigator;

    public ProductPresenterImpl(IExecutor executor, IMainThread mainThread,
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
    public void onProductRetrieved(Product products) {
        mView.hideProgress();
        mView.displayProductInformation(products);
    }

    @Override
    public void onRetrievalFailed(String error) {
        mView.hideProgress();
        onError(error);
    }

    @Override
    public void setNavigator(INavigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void navigateToNewScreen() {
        this.mNavigator.launchActivity();
    }
}
