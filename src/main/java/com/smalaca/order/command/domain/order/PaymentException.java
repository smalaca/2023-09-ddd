package com.smalaca.order.command.domain.order;

class PaymentException extends RuntimeException {
    PaymentException(OrderNumber orderNumber) {
    }
}
