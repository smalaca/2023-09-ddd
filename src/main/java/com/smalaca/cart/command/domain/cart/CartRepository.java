package com.smalaca.cart.command.domain.cart;

import com.smalaca.annotations.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface CartRepository {
    Cart findById(UUID cartId);

    void save(Cart cart);
}
