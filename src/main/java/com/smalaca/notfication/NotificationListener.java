package com.smalaca.notfication;

import com.smalaca.cart.command.domain.cart.UnavailableProductRecognized;
import com.smalaca.order.command.domain.order.OrderCancelled;
import org.springframework.context.event.EventListener;

public class NotificationListener {
    @EventListener
    public void notify(UnavailableProductRecognized event) {

    }

    @EventListener
    public void notify(OrderCancelled event) {

    }
}
