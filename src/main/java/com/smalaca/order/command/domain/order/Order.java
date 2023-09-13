package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.order.command.domain.purchase.Purchase;

@AggregateRoot
public class Order {
    public Purchase pay() {
        return null;
    }

    public void cancel() {

    }
}
