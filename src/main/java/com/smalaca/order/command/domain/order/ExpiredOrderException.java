package com.smalaca.order.command.domain.order;

class ExpiredOrderException extends RuntimeException {
    ExpiredOrderException(OrderNumber orderNumber) {
    }
}
