package com.azurehorsecreations.shopper.data.repository;

import com.azurehorsecreations.shopper.domain.repository.MessageRepository;

/**
 * Created by pattycase on 9/8/17.
 */

public class WelcomeMessageRepository implements MessageRepository {
    @Override
    public String getWelcomeMessage() {
        String msg = "Welcome, friend!"; // let's be friendly


        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return msg;
    }
}
