package com.smalaca.order.command.domain.purchase;

import com.smalaca.annotations.ddd.AggregateRoot;
import com.smalaca.order.command.domain.price.Price;

import java.util.UUID;

@AggregateRoot
public class Purchase {
    private UUID purchaseId;

    private PurchaseNumber purchaseNumber;
    private UUID orderId;
    private Price price;
    private UUID paymentMethod;
    private UUID deliveryMethod;
    private UUID buyerId;
    private UUID sellerId;

    private Purchase(Builder builder) {
        this.purchaseNumber = builder.purchaseNumber;
        this.orderId = builder.orderId;
        this.price = builder.price;
        this.paymentMethod = builder.paymentMethod;
        this.deliveryMethod = builder.deliveryMethod;
        this.buyerId = builder.buyerId;
        this.sellerId = builder.sellerId;
    }

    public UUID getId() {
        return purchaseId;
    }

    public static class Builder {
        private final PurchaseNumber purchaseNumber;
        private UUID orderId;
        private UUID paymentMethod;
        private UUID deliveryMethod;
        private Price price;
        private UUID buyerId;
        private UUID sellerId;

        private Builder(PurchaseNumber purchaseNumber) {
             this.purchaseNumber = purchaseNumber;
        }

        public static Builder purchase() {
            return new Builder(PurchaseNumber.generate());
        }

        public Purchase build() {
            return new Purchase(this);
        }

        public Builder orderId(UUID orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder price(Price price) {
            this.price = price;
            return this;
        }

        public Builder paymentMethod(UUID paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder deliveryMethod(UUID deliveryMethod) {
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        public Builder buyerId(UUID buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public Builder sellerId(UUID sellerId) {
            this.sellerId = sellerId;
            return this;
        }
    }
}
