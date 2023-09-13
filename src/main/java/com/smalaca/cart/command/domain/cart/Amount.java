package com.smalaca.cart.command.domain.cart;

import com.smalaca.annotations.ddd.Factory;
import com.smalaca.annotations.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    @Factory
    public static Amount from(int amount) {
        if (amount < 1) {
            throw new AmountException(amount);
        }

        return new Amount(amount);
    }

    Amount increment(Amount amount) {
        return new Amount(value + amount.value);
    }

    Amount decrement(Amount amount) {
        return new Amount(value - amount.value);
    }

    boolean greaterThan(Amount amount) {
        return value > amount.value;
    }
}
