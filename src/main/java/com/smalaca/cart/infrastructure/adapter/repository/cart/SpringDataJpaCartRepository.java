package com.smalaca.cart.infrastructure.adapter.repository.cart;

import com.smalaca.cart.command.domain.cart.Cart;
import com.smalaca.cart.command.domain.cart.CartRepository;

import java.util.UUID;

public class SpringDataJpaCartRepository implements CartRepository {
    @Override
    public Cart findById(UUID cartId) {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }
}
