package com.smalaca.cart.command.domain.cart;

public interface EventRegistry {
    void publish(InvalidAmountFound invalidAmountFound);
}
