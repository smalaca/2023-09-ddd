package com.smalaca.order.command.application.order;

import com.smalaca.order.command.domain.order.Order;
import com.smalaca.order.command.domain.order.OrderRepository;
import com.smalaca.order.command.domain.purchase.Purchase;
import com.smalaca.order.command.domain.purchase.PurchaseRepository;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;

    public OrderApplicationService(OrderRepository orderRepository, PurchaseRepository purchaseRepository) {
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void pay(PayDto dto) {
        Order order = orderRepository.findById(dto.getOrderId());

        Purchase purchase = order.pay();

        purchaseRepository.save(purchase);
    }
}
