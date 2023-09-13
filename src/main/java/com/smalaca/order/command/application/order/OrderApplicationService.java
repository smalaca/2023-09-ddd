package com.smalaca.order.command.application.order;

import com.smalaca.order.command.domain.order.Order;
import com.smalaca.order.command.domain.order.OrderFactory;
import com.smalaca.order.command.domain.order.OrderRepository;
import com.smalaca.order.command.domain.purchase.Purchase;
import com.smalaca.order.command.domain.purchase.PurchaseRepository;

import javax.transaction.Transactional;
import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;
    private final OrderFactory orderFactory;

    public OrderApplicationService(
            OrderRepository orderRepository, PurchaseRepository purchaseRepository, OrderFactory orderFactory) {
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
        this.orderFactory = orderFactory;
    }

    @Transactional
    public UUID buy(BuyDto dto) {
        Order order = orderFactory.create(dto.getBuyerId(), dto.getProducts());

        return orderRepository.save(order);
    }

    @Transactional
    public UUID pay(PayDto dto) {
        Order order = orderRepository.findById(dto.getOrderId());

        Purchase purchase = order.pay(dto.getPaymentMethod(), dto.getDeliveryMethod());

        return purchaseRepository.save(purchase);
    }

    @Transactional
    public void cancel(CancelDto dto) {
        Order order = orderRepository.findById(dto.getOrderId());

        order.cancel();

        orderRepository.save(order);
    }
}
