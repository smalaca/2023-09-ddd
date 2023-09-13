package com.smalaca.order.infrastructure.adapter.eventregistry;

import com.smalaca.order.command.domain.eventregistry.EventRegistry;
import com.smalaca.order.command.domain.order.OrderCancelled;

public class KafkaEventRegistry implements EventRegistry {
    @Override
    public void publish(OrderCancelled orderCancelled) {

    }
}
