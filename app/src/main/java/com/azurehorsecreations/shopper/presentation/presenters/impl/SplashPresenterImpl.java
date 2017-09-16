package com.azurehorsecreations.shopper.presentation.presenters.impl;

import com.azurehorsecreations.shopper.presentation.presenters.SplashPresenter;
import com.azurehorsecreations.shopper.presentation.ui.navigation.Navigator;

/**
 * Created by pattycase on 9/16/17.
 */

public class SplashPresenterImpl implements SplashPresenter {
    private Navigator mNavigator;

    @Override
    public void resume() {
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

    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void navigateToNewScreen() {
        this.mNavigator.launchActivity();
    }
}
