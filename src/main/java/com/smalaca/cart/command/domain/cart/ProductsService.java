package com.smalaca.cart.command.domain.cart;

import java.util.UUID;

public interface ProductsService {
    boolean doesNotExist(UUID productId, Amount amount);
}
