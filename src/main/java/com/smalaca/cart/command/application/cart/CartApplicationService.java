package com.smalaca.cart.command.application.cart;

import com.smalaca.cart.command.domain.cart.Amount;
import com.smalaca.cart.command.domain.cart.Cart;
import com.smalaca.cart.command.domain.cart.CartRepository;
import com.smalaca.cart.command.domain.cart.ProductsService;

import javax.transaction.Transactional;

public class CartApplicationService {
    private final CartRepository cartRepository;
    private final ProductsService productsService;

    public CartApplicationService(CartRepository cartRepository, ProductsService productsService) {
        this.cartRepository = cartRepository;
        this.productsService = productsService;
    }

    @Transactional
    public void addProduct(AddProductDto dto) {
        // transformacja z typów prostych na ubiquitous language [0..*]
        Cart cart = cartRepository.findById(dto.getCartId());
        Amount amount = Amount.from(dto.getAmount());

        // wywołanie metody z domeny: 1
        cart.addProduct(dto.getProductId(), amount, productsService);

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
