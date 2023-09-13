package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.annotations.ddd.Factory;
import com.smalaca.order.command.domain.purchase.Purchase;

import java.util.UUID;

@AggregateRoot
public class Order {
    private UUID orderId;

    @Factory
    public Purchase pay() {
        return null;
    }

    public void cancel() {

    }

    public UUID getId() {
        return orderId;
    }
}
