package com.smalaca.cart.command.application.cart;

import java.util.UUID;

public class AddProductDto {
    private UUID cartId;

    UUID getCartId() {
        return cartId;
    }
}
