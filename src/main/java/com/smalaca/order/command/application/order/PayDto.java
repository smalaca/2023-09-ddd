package com.smalaca.order.command.application.order;

import java.util.UUID;

public class PayDto {
    private UUID orderId;
    private UUID paymentMethod;
    private UUID deliveryMethod;

    UUID getOrderId() {
        return orderId;
    }

    UUID getPaymentMethod() {
        return paymentMethod;
    }

    UUID getDeliveryMethod() {
        return deliveryMethod;
    }
}
