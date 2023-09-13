package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.annotations.ddd.Factory;
import com.smalaca.order.command.domain.price.Price;
import com.smalaca.order.command.domain.purchase.Purchase;

import java.time.LocalDateTime;
import java.util.UUID;

@AggregateRoot
public class Order {
    private UUID orderId;
    private UUID buyerId;
    private UUID sellerId;
    private OrderNumber orderNumber;
    private Price price;
    private LocalDateTime creationDateTime;

    private PaymentService paymentService;

    Order(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Factory
    public Purchase pay(UUID paymentMethod, UUID deliveryMethod) {
        if (isExpired()) {
            throw new ExpiredOrderException(orderNumber);
        }

        paymentService.pay(new Payment(buyerId, sellerId, price));

        return Purchase.Builder.purchase()
                .price(price)
                .orderId(orderId)
                .buyerId(buyerId)
                .sellerId(sellerId)
                .paymentMethod(paymentMethod)
                .deliveryMethod(deliveryMethod)
                .build();
    }

    private boolean isExpired() {
        return creationDateTime.isBefore(LocalDateTime.now().minusMinutes(10));
    }

    public void cancel() {

    }

    public UUID getId() {
        return orderId;
    }
}
