package com.smalaca.order.command.domain.order;

import com.smalaca.order.command.domain.price.Price;

import java.util.UUID;

public class Payment {
    private final UUID buyerId;
    private final UUID sellerId;
    private final Price price;

    Payment(UUID buyerId, UUID sellerId, Price price) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
    }
}
