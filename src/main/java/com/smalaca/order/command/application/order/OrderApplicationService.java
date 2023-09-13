package com.smalaca.order.command.application.order;

import com.smalaca.order.command.domain.order.Order;
import com.smalaca.order.command.domain.order.OrderRepository;
import com.smalaca.order.command.domain.purchase.Purchase;
import com.smalaca.order.command.domain.purchase.PurchaseRepository;

import javax.transaction.Transactional;
import java.util.UUID;

public class OrderApplicationService {
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;

    public OrderApplicationService(OrderRepository orderRepository, PurchaseRepository purchaseRepository) {
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Transactional
    public UUID buy(BuyDto dto) {
        Order order = new Order();

        return orderRepository.save(order);
    }

    @Transactional
    public UUID pay(PayDto dto) {
        Order order = orderRepository.findById(dto.getOrderId());

        Purchase purchase = order.pay();

        return purchaseRepository.save(purchase);
    }

    @Transactional
    public void cancel(CancelDto dto) {
        Order order = orderRepository.findById(dto.getOrderId());

        order.cancel();

        orderRepository.save(order);
    }
}
