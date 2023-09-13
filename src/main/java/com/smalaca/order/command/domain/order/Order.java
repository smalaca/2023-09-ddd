package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.annotations.ddd.Factory;
import com.smalaca.order.command.domain.eventregistry.EventRegistry;
import com.smalaca.order.command.domain.price.Price;
import com.smalaca.order.command.domain.purchase.Purchase;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Order {
    private UUID orderId;
    private UUID buyerId;
    private List<OrderItem> orderItems;
    private OrderNumber orderNumber;
    private LocalDateTime creationDateTime;
    private boolean isCanceled;

    private PaymentService paymentService;
    private EventRegistry eventRegistry;

    Order(UUID buyerId, List<OrderItem> orderItems, LocalDateTime creationDateTime, OrderNumber orderNumber) {
        this.buyerId = buyerId;
        this.orderItems = orderItems;
        this.creationDateTime = creationDateTime;
        this.orderNumber = orderNumber;
    }

    @Factory
    public Purchase pay(UUID paymentMethod, UUID deliveryMethod) {
        if (isCanceled) {
            throw new CancelledOrderException(orderNumber);
        }

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
        isCanceled = true;
        eventRegistry.publish(new OrderCancelled(buyerId, orderId, orderNumber.getValue(), products()));
    }

    private Map<UUID, Integer> products() {
        Map<UUID, Integer> products = new HashMap<>();
        orderItems.forEach(orderItem -> products.put(orderItem.getProductId(), orderItem.getAmount()));
        return products;
    }

    public UUID getId() {
        return orderId;
    }
}
