package com.azurehorsecreations.shopper.domain.interactors.impl;

import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.WelcomingInteractor;
import com.azurehorsecreations.shopper.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.shopper.domain.repository.MessageRepository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class WelcomingInteractorImpl extends AbstractInteractor implements WelcomingInteractor {

    private WelcomingInteractor.Callback mCallback;
    private MessageRepository mMessageRepository;

    public WelcomingInteractorImpl(Executor threadExecutor,
                                   MainThread mainThread,
                                   Callback callback, MessageRepository messageRepository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mMessageRepository = messageRepository;
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("Nothing to welcome you with :(");
            }
        });
    }

    private void postMessage(final String msg) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onMessageRetrieved(msg);
            }
        });
    }

    @Override
    public void run() {

        // retrieve the message
        final String message = mMessageRepository.getWelcomeMessage();

        // check if we have failed to retrieve our message
        if (message == null || message.length() == 0) {

            // notify the failure on the main thread
            notifyError();

            return;
        }

        // we have retrieved our message, notify the UI on the main thread
        postMessage(message);
    }
}
