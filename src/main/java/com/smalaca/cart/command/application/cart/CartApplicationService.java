package com.smalaca.cart.command.application.cart;

import com.smalaca.cart.command.domain.cart.Amount;
import com.smalaca.cart.command.domain.cart.Cart;
import com.smalaca.cart.command.domain.cart.CartRepository;

import javax.transaction.Transactional;

public class CartApplicationService {
    private final CartRepository cartRepository;

    public CartApplicationService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public void addProduct(AddProductDto dto) {
        // transformacja z typów prostych na ubiquitous language [0..*]
        Cart cart = cartRepository.findById(dto.getCartId());
        Amount amount = Amount.from(dto.getAmount());

        // wywołanie metody z domeny: 1
        cart.addProduct(dto.getProductId(), amount);

        // zapis operacji na domenie [0..*]
        cartRepository.save(cart);
    }

    @Transactional
    public void removeProduct(RemoveProductDto dto) {
        // transformacja z typów prostych na ubiquitous language [0..*]
        Cart cart = cartRepository.findById(dto.getCartId());

        // wywołanie metody z domeny: 1
        cart.removeProduct();

        // zapis operacji na domenie [0..*]
        cartRepository.save(cart);
    }
}
