package com.smalaca.order.command.domain.purchase;

import com.smalaca.annotations.ddd.AggregateRoot;

import java.util.UUID;

@AggregateRoot
public class Purchase {
    private UUID orderId;
}
