package com.smalaca.order.command.application.order;

import java.util.UUID;

public class CancelDto {
    private UUID orderId;

    UUID getOrderId() {
        return orderId;
    }
}
