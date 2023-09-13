package com.smalaca.cart.command.domain.eventregistry;

import com.smalaca.cart.command.domain.cart.UnavailableProductRecognized;

public interface EventRegistry {
    void publish(UnavailableProductRecognized unavailableProductRecognized);
}
