package com.smalaca.order.command.application.order;

import java.util.UUID;

public class PayDto {
    private UUID orderId;

    UUID getOrderId() {
        return orderId;
    }
}
