package com.smalaca.order.command.domain.order;

class CancelledOrderException extends RuntimeException {
    CancelledOrderException(OrderNumber orderNumber) {
    }
}
