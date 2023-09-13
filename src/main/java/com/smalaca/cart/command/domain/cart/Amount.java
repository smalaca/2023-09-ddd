package com.smalaca.cart.command.domain.cart;

import com.smalaca.annotations.ddd.Factory;
import com.smalaca.annotations.ddd.ValueObject;

@ValueObject
public class Amount {
    private static EventRegistry eventRegistry;
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    @Factory
    public static Amount from(int amount) {
        if (amount < 1) {
            eventRegistry.publish(new InvalidAmountFound(amount));
        }

        return new Amount(amount);
    }

    Amount increment(Amount amount) {
        return new Amount(value + amount.value);
    }
}
