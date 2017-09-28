package com.azurehorsecreations.photoalbum.presentation.ui.navigation;

import android.content.Context;
import android.content.Intent;

/**
 * Created by pattycase on 9/14/17.
 */

public class ActivityNavigationCommand {

    private Context mContext;

    public ActivityNavigationCommand(Context context) {
        this.mContext = context;
    }

    public void navigate(Class<?> cls) {
        mContext.startActivity(new Intent(mContext, cls));
    }
}
