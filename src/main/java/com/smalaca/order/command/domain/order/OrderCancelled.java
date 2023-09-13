package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.DomainEvent;

import java.util.Map;
import java.util.UUID;

@DomainEvent
public class OrderCancelled {
    private final UUID buyerId;
    private final UUID orderId;
    private final String orderNumber;
    private final Map<UUID, Integer> products;

    OrderCancelled(UUID buyerId, UUID orderId, String orderNumber, Map<UUID, Integer> products) {
        this.buyerId = buyerId;
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.products = products;
    }
}
