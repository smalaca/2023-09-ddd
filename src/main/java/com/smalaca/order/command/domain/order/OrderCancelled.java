package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.DomainEvent;

import java.util.Map;
import java.util.UUID;

@DomainEvent
public class OrderCancelled {
    OrderCancelled(UUID buyerId, UUID orderId, String orderNumber, Map<UUID, Integer> products) {

    }
}
