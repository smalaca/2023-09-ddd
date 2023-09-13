package com.smalaca.order.infrastructure.adapter.repository.purchase;

import com.smalaca.order.command.domain.purchase.Purchase;
import com.smalaca.order.command.domain.purchase.PurchaseRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryPurchaseRepository implements PurchaseRepository {
    private final Map<UUID, Purchase> purchases = new HashMap<>();

    @Override
    public UUID save(Purchase purchase) {
        UUID purchaseId = purchase.getId();
        purchases.put(purchaseId, purchase);
        return purchaseId;
    }
}
