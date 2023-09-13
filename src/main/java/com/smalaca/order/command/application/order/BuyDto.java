package com.smalaca.order.command.application.order;

import java.util.Map;
import java.util.UUID;

public class BuyDto {
    private Map<UUID, Integer> products;
    private UUID buyerId;

    Map<UUID, Integer> getProducts() {
        return products;
    }

    UUID getBuyerId() {
        return buyerId;
    }
}
