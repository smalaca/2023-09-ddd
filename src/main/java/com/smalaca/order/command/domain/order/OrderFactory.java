package com.smalaca.order.command.domain.order;

public class OrderFactory {
    public Order create() {
        return new Order(OrderNumber.generate());
    }
}
