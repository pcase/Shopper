package com.azurehorsecreations.shopper.presentation.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.azurehorsecreations.shopper.domain.model.Product;

/**
 * Created by pattycase on 9/14/17.
 */

public class ProductNavigator implements INavigator {
    private final Context mActivityContext;
    private final Class<?> mClassToNavigateTo;
    private final Product mProduct;

    public ProductNavigator(Context activityContext, Class<?> cls, Product product) {
        this.mActivityContext = activityContext;
        this.mClassToNavigateTo = cls;
        this.mProduct = product;
    }

    @Override
    public void launchActivity() {
        Intent intent = new Intent(mActivityContext, mClassToNavigateTo);
        intent.putExtra("PRODUCT", mProduct);
        mActivityContext.startActivity(intent);
    }
}
