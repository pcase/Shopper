package com.azurehorsecreations.photoalbum.presentation.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;

/**
 * Created by pattycase on 9/14/17.
 */

public class PhotoNavigator implements INavigator {
    private final Context mActivityContext;
    private final Class<?> mClassToNavigateTo;
    private PhotoMetadata mPhoto;

    public PhotoNavigator(Context activityContext, Class<?> cls, PhotoMetadata photo) {
        this.mActivityContext = activityContext;
        this.mClassToNavigateTo = cls;
        this.mPhoto = photo;
    }

    @Override
    public void launchActivity() {
        Intent intent = new Intent(mActivityContext, mClassToNavigateTo);
        intent.putExtra("PHOTO", mPhoto);
        mActivityContext.startActivity(intent);
    }
}
