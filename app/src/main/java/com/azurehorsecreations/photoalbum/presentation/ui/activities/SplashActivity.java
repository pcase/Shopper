package com.azurehorsecreations.photoalbum.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.azurehorsecreations.photoalbum.presentation.presenters.ISplashPresenter;
import com.azurehorsecreations.photoalbum.presentation.presenters.impl.SplashPresenterImpl;
import com.azurehorsecreations.photoalbum.presentation.ui.navigation.SplashNavigator;

/*
 * SplashActivity displays the splash screen
 */

public class SplashActivity extends AppCompatActivity {
    protected ISplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SplashPresenterImpl();
        mPresenter.setNavigator(new SplashNavigator(this, PhotoActivity.class));
        mPresenter.navigateToNewScreen();
        finish();
    }
}


