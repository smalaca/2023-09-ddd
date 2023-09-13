package com.smalaca.cart.infrastructure.adapter.products;

import com.smalaca.cart.command.domain.cart.Amount;
import com.smalaca.cart.command.domain.cart.ProductsService;
import com.smalaca.products.ProductsApi;

import java.util.UUID;

public class Products implements ProductsService {
    private final ProductsApi productsApi;

    public Products(ProductsApi productsApi) {
        this.productsApi = productsApi;
    }

    @Override
    public boolean doesNotExist(UUID productId, Amount amount) {
        return productsApi.doesNotExist(productId, amount);
    }
}
