package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.order.command.domain.purchase.Purchase;

import java.util.UUID;

@AggregateRoot
public class Order {
    private UUID orderId;

    public Purchase pay() {
        return null;
    }

    public void cancel() {

    }
}
