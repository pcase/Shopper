package com.azurehorsecreations.photoalbum.presentation.ui.navigation;

import android.content.Context;
import android.content.Intent;

/**
 * Created by pattycase on 9/14/17.
 */

public class SplashNavigator implements INavigator {
    private final Context mActivityContext;
    private final Class<?> mClassToNavigateTo;

    public SplashNavigator(Context activityContext, Class<?> cls) {
        this.mActivityContext = activityContext;
        this.mClassToNavigateTo = cls;
    }

    @Override
    public void launchActivity() {
        Intent intent = new Intent(mActivityContext, mClassToNavigateTo);
        mActivityContext.startActivity(intent);
    }
}
