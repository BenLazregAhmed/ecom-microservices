package org.ahmed.ecom.mappers;

import org.ahmed.ecom.dtos.OrderRequest;
import org.ahmed.ecom.dtos.OrderResponse;
import org.ahmed.ecom.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request){
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .paymentMethod(request.paymentMethod())
                .reference(request.reference())
                .totalAmount(request.amount())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
