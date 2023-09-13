package com.smalaca.order.command.domain.order;

import java.util.Map;
import java.util.UUID;

class NotAvailableProductException extends RuntimeException {
    NotAvailableProductException(Map<UUID, Integer> products) {
    }
}
