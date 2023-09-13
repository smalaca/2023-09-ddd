package com.smalaca.order.command.domain.price;

import com.smalaca.annotations.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }
}
