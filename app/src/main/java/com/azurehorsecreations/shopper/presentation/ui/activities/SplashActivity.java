package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.presenters.ProductPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.SplashPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.impl.SplashPresenterImpl;
import com.azurehorsecreations.shopper.presentation.ui.navigation.Navigator;
import com.azurehorsecreations.shopper.presentation.ui.navigation.ProductNavigator;
import com.azurehorsecreations.shopper.presentation.ui.navigation.SplashNavigator;

import java.util.List;

/*
 * SplashActivity displays the splash screen
 */

public class SplashActivity extends AppCompatActivity {
    protected SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SplashPresenterImpl();
        mPresenter.setNavigator(new SplashNavigator(this, ProductActivity.class));
        mPresenter.navigateToNewScreen();
        finish();
    }
}


