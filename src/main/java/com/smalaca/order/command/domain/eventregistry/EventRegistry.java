package com.smalaca.order.command.domain.eventregistry;

import com.smalaca.order.command.domain.order.OrderCancelled;

public interface EventRegistry {
    void publish(OrderCancelled orderCancelled);
}
