package com.smalaca.order.infrastructure.adapter.repository.order;

import com.smalaca.order.command.domain.order.Order;
import com.smalaca.order.command.domain.order.OrderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<UUID, Order> orders = new HashMap<>();

    @Override
    public Order findById(UUID orderId) {
        return orders.get(orderId);
    }

    @Override
    public UUID save(Order order) {
        UUID orderId = order.getId();
        orders.put(orderId, order);
        return orderId;
    }
}
