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

    private ProductsService productsService;

    private final Map<UUID, Amount> products = new HashMap<>();

    public void addProduct(UUID productId, Amount amount) {
        if (doesNotExist(productId, amount)) {
            throw new NotExistingProductException(productId, amount);
        }

        if (has(productId)) {
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

    public void removeProduct(UUID productId, Amount amount) {
        if (has(productId)) {
            Amount current = products.get(productId);

            if (current.greaterThan(amount)) {
                Amount decremented = current.decrement(amount);
                products.put(productId, decremented);
            } else {
                products.remove(productId);
            }

        }
    }

    private boolean has(UUID productId) {
        return products.containsKey(productId);
    }
}
