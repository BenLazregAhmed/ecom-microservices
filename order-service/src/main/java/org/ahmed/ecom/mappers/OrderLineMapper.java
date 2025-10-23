package org.ahmed.ecom.mappers;

import org.ahmed.ecom.dtos.OrderLineRequest;
import org.ahmed.ecom.dtos.OrderLineResponse;
import org.ahmed.ecom.entities.Order;
import org.ahmed.ecom.entities.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request){
        return OrderLine.builder()
                .id(request.id())
                .order(Order.builder()
                        .id(request.orderId())
                        .build())
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
