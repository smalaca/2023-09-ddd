package com.smalaca.cart.command.domain.cart;

import com.smalaca.annotations.ddd.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@AggregateRoot
public class Cart {
    @Id
    @GeneratedValue
    private UUID cartId;

    private UUID buyerId;

    private final Map<UUID, Amount> products = new HashMap<>();

    private ProductsService productsService;

    public void init(ProductsService productsService) {
        this.productsService = productsService;
    }

    public void addProduct(UUID productId, Amount amount) {
        if (doesNotExist(productId, amount)) {
            throw new NotExistingProductException(productId, amount);
        }

        if (products.containsKey(productId)) {
            Amount oldAmount = products.get(productId);
            Amount incremented = oldAmount.increment(amount);
            products.put(productId, incremented);
        } else {
            products.put(productId, amount);
        }
    }

    private boolean doesNotExist(UUID productId, Amount amount) {
        return productsService.doesNotExist(productId, amount);
    }

    public void removeProduct() {

    }
}
