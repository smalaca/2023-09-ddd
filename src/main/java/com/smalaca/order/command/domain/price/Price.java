package com.smalaca.order.command.domain.price;

import com.smalaca.annotations.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    public static final Price ZERO = new Price(BigDecimal.ZERO);
    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }

    public Price add(Price price) {
        return new Price(value.add(price.value));
    }
}
