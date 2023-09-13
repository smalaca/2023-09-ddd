package com.smalaca.order.command.domain.purchase;

import com.smalaca.annotations.ddd.DomainRepository;

@DomainRepository
public interface PurchaseRepository {
    void save(Purchase purchase);
}
