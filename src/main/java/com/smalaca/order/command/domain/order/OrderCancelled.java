package com.smalaca.order.command.domain.order;

import java.util.Map;
import java.util.UUID;

public class OrderCancelled {
    OrderCancelled(UUID buyerId, UUID orderId, String orderNumber, Map<UUID, Integer> products) {

    }
}
