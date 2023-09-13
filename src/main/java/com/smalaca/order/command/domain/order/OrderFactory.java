package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.Factory;

@Factory
public class OrderFactory {
    public Order create() {
        return new Order(OrderNumber.generate());
    }
}
