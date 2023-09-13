package com.smalaca.cart.infrastructure.adapter.eventregistry;

import com.smalaca.cart.command.domain.cart.UnavailableProductRecognized;
import com.smalaca.cart.command.domain.eventregistry.EventRegistry;

public class KafkaEventRegistry implements EventRegistry {
    @Override
    public void publish(UnavailableProductRecognized unavailableProductRecognized) {

    }
}
