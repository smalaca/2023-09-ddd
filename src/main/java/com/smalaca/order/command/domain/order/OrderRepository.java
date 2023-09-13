package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface OrderRepository {
    Order findById(UUID orderId);

    UUID save(Order order);
}
