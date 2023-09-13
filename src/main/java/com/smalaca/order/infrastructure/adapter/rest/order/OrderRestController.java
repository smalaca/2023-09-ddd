package com.smalaca.order.infrastructure.adapter.rest.order;

import com.smalaca.order.command.application.order.BuyDto;
import com.smalaca.order.command.application.order.CancelDto;
import com.smalaca.order.command.application.order.OrderApplicationService;
import com.smalaca.order.command.application.order.PayDto;
import com.smalaca.order.query.order.OrderDataModel;
import com.smalaca.order.query.order.OrderQueryService;

import java.util.UUID;

public class OrderRestController {
    private final OrderApplicationService orderApplicationService;
    private final OrderQueryService orderQueryService;

    public OrderRestController(OrderApplicationService orderApplicationService, OrderQueryService orderQueryService) {
        this.orderApplicationService = orderApplicationService;
        this.orderQueryService = orderQueryService;
    }

    public UUID buy(BuyDto dto) {
        return orderApplicationService.buy(dto);
    }

    public UUID pay(PayDto dto) {
        return orderApplicationService.pay(dto);
    }

    public void cancel(CancelDto dto) {
        orderApplicationService.cancel(dto);
    }

    public OrderDataModel display(UUID orderId) {
        return orderQueryService.findById(orderId);
    }
}
