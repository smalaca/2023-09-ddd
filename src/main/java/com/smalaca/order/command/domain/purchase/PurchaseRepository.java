package com.smalaca.order.command.domain.purchase;

import com.smalaca.annotations.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
public interface PurchaseRepository {
    UUID save(Purchase purchase);
}
