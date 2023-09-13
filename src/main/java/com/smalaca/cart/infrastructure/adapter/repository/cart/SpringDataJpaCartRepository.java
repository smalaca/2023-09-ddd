package com.smalaca.cart.infrastructure.adapter.repository.cart;

import com.smalaca.cart.command.domain.cart.Cart;
import com.smalaca.cart.command.domain.cart.CartRepository;
import com.smalaca.cart.command.domain.cart.ProductsService;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public class SpringDataJpaCartRepository implements CartRepository {
    private CrudRepository<Cart, UUID> repository;
    private ProductsService productsService;

    @Override
    public Cart findById(UUID cartId) {
        Cart cart = repository.findById(cartId).get();
        cart.init(productsService);
        return cart;
    }

    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }
}
