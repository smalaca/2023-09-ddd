package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.ValueObject;
import com.smalaca.order.command.domain.price.Price;

import java.util.UUID;

@ValueObject
public class OrderItem {
    private UUID productId;
    private UUID sellerId;
    private int amount;
    private Price price;

    UUID getSellerId() {
        return sellerId;
    }

    Price getPrice() {
        return price.multiply(amount);
    }

    UUID getProductId() {
        return productId;
    }

    int getAmount() {
        return amount;
    }
}
