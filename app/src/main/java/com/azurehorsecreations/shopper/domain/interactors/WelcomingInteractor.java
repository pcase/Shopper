package com.azurehorsecreations.shopper.domain.interactors;


import com.azurehorsecreations.shopper.domain.interactors.base.Interactor;


public interface WelcomingInteractor extends Interactor {

    interface Callback {
        void onMessageRetrieved(String message);

        void onRetrievalFailed(String error);
    }
}
