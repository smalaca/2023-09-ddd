package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.ValueObject;

import java.util.UUID;

@ValueObject
public class OrderNumber {
    private final String value;

    private OrderNumber(String value) {
        this.value = value;
    }

    static OrderNumber generate() {
        return new OrderNumber(uniqueOrderNumber());
    }

    private static String uniqueOrderNumber() {
        return UUID.randomUUID().toString();
    }
}
