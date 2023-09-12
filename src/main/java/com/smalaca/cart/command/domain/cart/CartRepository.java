package com.smalaca.cart.command.domain.cart;

import java.util.UUID;

public interface CartRepository {
    Cart findById(UUID cartId);

    void save(Cart cart);
}
