package com.azurehorsecreations.shopper.domain.repository;

/**
 * A repository that is responsible for getting our welcome message.
 */
public interface MessageRepository {
    String getWelcomeMessage();
}