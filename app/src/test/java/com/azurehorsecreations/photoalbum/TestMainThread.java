package com.azurehorsecreations.photoalbum;

import com.azurehorsecreations.photoalbum.domain.executor.IMainThread;

/**
 * Created by dmilicic on 1/8/16.
 */
public class TestMainThread implements IMainThread {

    @Override
    public void post(Runnable runnable) {
        // tests can run on this thread, no need to invoke other threads
        runnable.run();
    }
}
