package com.smalaca.products;

import com.smalaca.cart.command.domain.cart.Amount;

import java.util.UUID;

public class ProductsApi {
    public boolean doesNotExist(UUID productId, Amount amount) {
        return false;
    }
}
