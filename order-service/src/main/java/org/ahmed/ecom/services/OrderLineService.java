package org.ahmed.ecom.services;

import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.OrderLineRequest;
import org.ahmed.ecom.dtos.OrderLineResponse;
import org.ahmed.ecom.mappers.OrderLineMapper;
import org.ahmed.ecom.repositories.OrderLineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepo orderLineRepo;
    private final OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        System.out.println(orderLineRequest);
        var orderLine=mapper.toOrderLine(orderLineRequest);
        System.out.println(orderLine);
        return orderLineRepo.save(orderLine).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepo.findAllByOrderId(orderId)
                .stream().map(mapper::toOrderLineResponse).toList();
    }
}
