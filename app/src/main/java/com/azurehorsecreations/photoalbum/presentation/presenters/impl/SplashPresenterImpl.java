package com.azurehorsecreations.photoalbum.presentation.presenters.impl;

import com.azurehorsecreations.photoalbum.presentation.presenters.ISplashPresenter;
import com.azurehorsecreations.photoalbum.presentation.ui.navigation.INavigator;

/**
 * Created by pattycase on 9/16/17.
 */

public class SplashPresenterImpl implements ISplashPresenter {
    private INavigator mNavigator;

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
    public void setNavigator(INavigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void navigateToNewScreen() {
        this.mNavigator.launchActivity();
    }
}
