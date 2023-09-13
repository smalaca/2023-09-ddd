package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.annotations.ddd.Factory;
import com.smalaca.order.command.domain.price.Price;
import com.smalaca.order.command.domain.purchase.Purchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Order {
    private UUID orderId;
    private UUID buyerId;
    private List<OrderItem> orderItems;
    private OrderNumber orderNumber;
    private LocalDateTime creationDateTime;

    private PaymentService paymentService;

    Order(UUID buyerId, List<OrderItem> orderItems, LocalDateTime creationDateTime, OrderNumber orderNumber) {
        this.buyerId = buyerId;
        this.orderItems = orderItems;
        this.creationDateTime = creationDateTime;
        this.orderNumber = orderNumber;
    }

    @Factory
    public Purchase pay(UUID paymentMethod, UUID deliveryMethod) {
        if (isExpired()) {
            throw new ExpiredOrderException(orderNumber);
        }

        Price price = totalPrice();
        paymentService.pay(new Payment(buyerId, getSellerId(), price));

        return Purchase.Builder.purchase()
                .price(price)
                .orderId(orderId)
                .buyerId(buyerId)
                .sellerId(getSellerId())
                .paymentMethod(paymentMethod)
                .deliveryMethod(deliveryMethod)
                .build();
    }

    private UUID getSellerId() {
        return orderItems.get(0).getSellerId();
    }

    private Price totalPrice() {
        return orderItems.stream()
                .map(OrderItem::getPrice)
                .reduce(Price.ZERO, Price::add);
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
