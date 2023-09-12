package com.smalaca.cart.infrastructure.adapter.rest.cart;

import com.smalaca.cart.command.application.cart.AddProductDto;
import com.smalaca.cart.command.application.cart.CartApplicationService;
import com.smalaca.cart.command.application.cart.RemoveProductDto;
import com.smalaca.cart.query.cart.CartDataModel;
import com.smalaca.cart.query.cart.CartQueryService;

import java.util.UUID;

public class CartRestController {
    private final CartApplicationService cartApplicationService;
    private final CartQueryService cartQueryService;

    public CartRestController(CartApplicationService cartApplicationService, CartQueryService cartQueryService) {
        this.cartApplicationService = cartApplicationService;
        this.cartQueryService = cartQueryService;
    }

    public void addProduct(AddProductDto dto) {
        cartApplicationService.addProduct(dto);
    }

    public void removeProduct(RemoveProductDto dto) {
        cartApplicationService.removeProduct(dto);
    }

    public CartDataModel display(UUID cartId) {
        return cartQueryService.displayById(cartId);
    }
}
