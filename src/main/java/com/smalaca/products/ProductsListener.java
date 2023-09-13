package com.smalaca.products;

import com.smalaca.order.command.domain.order.OrderCancelled;
import org.springframework.context.event.EventListener;

public class ProductsListener {
    @EventListener
    public void increaseProductsAvailability(OrderCancelled event) {

    }
}
