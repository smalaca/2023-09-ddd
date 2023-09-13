package com.smalaca.cart.infrastructure.adapter.repository.cart;

import com.smalaca.cart.command.domain.cart.Cart;
import com.smalaca.cart.command.domain.cart.CartRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public class SpringDataJpaCartRepository implements CartRepository {
    private CrudRepository<Cart, UUID> repository;

    @Override
    public Cart findById(UUID cartId) {
        return repository.findById(cartId).get();
    }

    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }
}
