package com.smalaca.cart.command.application.cart;

import java.util.UUID;

public class AddProductDto {
    private UUID cartId;
    private int amount;
    private UUID productId;

    UUID getCartId() {
        return cartId;
    }

    int getAmount() {
        return amount;
    }

    UUID getProductId() {
        return productId;
    }
}
