package com.smalaca.cart.command.domain.cart;

import com.smalaca.annotations.ddd.DomainEvent;

import java.util.UUID;

@DomainEvent
public class UnavailableProductRecognized {
    private final UUID productId;
    private final int amount;

    UnavailableProductRecognized(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount.getValue();
    }

    public UUID getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }
}
