package com.smalaca.cart.command.domain.cart;

import java.util.UUID;

class NotExistingProductException extends RuntimeException {
    NotExistingProductException(UUID productId, Amount amount) {
    }
}
