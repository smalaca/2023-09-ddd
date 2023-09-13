package com.smalaca.order.command.domain.order;

import com.smalaca.annotations.ddd.Factory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Factory
public class OrderFactory {
    private final ProductsService productsService;

    public OrderFactory(ProductsService productsService) {
        this.productsService = productsService;
    }

    public Order create(UUID buyerId, Map<UUID, Integer> products) {
        List<OrderItem> existingOrderItems = productsService.bookAll(products);

        if (existingOrderItems.isEmpty()) {
            throw new NotAvailableProductException(products);
        } else {
            return new Order(
                    buyerId,
                    existingOrderItems,
                    LocalDateTime.now(),
                    OrderNumber.generate());
        }
    }
}
