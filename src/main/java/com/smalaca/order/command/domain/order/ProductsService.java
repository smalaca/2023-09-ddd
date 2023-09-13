package com.smalaca.order.command.domain.order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ProductsService {
    List<OrderItem> bookAll(Map<UUID, Integer> values);
}
