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

    public void addProduct(UUID productId, Amount amount, ProductsService productsService) {
        if (productsService.doesNotExist(productId, amount)) {
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

    public void removeProduct() {

    }
}
