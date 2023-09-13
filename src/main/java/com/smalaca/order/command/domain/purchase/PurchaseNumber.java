package com.smalaca.order.command.domain.purchase;

import com.smalaca.annotations.ddd.Factory;
import com.smalaca.annotations.ddd.ValueObject;

import java.util.UUID;

@ValueObject
class PurchaseNumber {
    private final String value;

    private PurchaseNumber(String value) {
        this.value = value;
    }

    @Factory
    static PurchaseNumber generate() {
        return new PurchaseNumber(uniqueOrderNumber());
    }

    private static String uniqueOrderNumber() {
        return UUID.randomUUID().toString();
    }
}
