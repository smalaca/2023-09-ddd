package com.smalaca.notfication;

import com.smalaca.cart.command.domain.cart.UnavailableProductRecognized;
import org.springframework.context.event.EventListener;

public class NotificationListener {
    @EventListener
    public void notify(UnavailableProductRecognized event) {

    }
}
