package org.ahmed.ecom.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.*;
import org.ahmed.ecom.exceptions.BusinessException;
import org.ahmed.ecom.kafka.OrderConfirmation;
import org.ahmed.ecom.kafka.OrderProducer;
import org.ahmed.ecom.mappers.OrderMapper;
import org.ahmed.ecom.repositories.OrderRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;
    private final OrderRepo orderRepo;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentRestClient paymentRestClient;
    @Transactional
    public Integer createOrder(OrderRequest request) throws BusinessException {
        System.out.println(request);
        var customer = customerRestClient.findCustomerById(request.customerId())
                .orElseThrow(()->new BusinessException("Cannot create the order::the customer doesn't exist"));
        var purchasedProducts=productRestClient.purchaseProducts(request.products());
        var order = orderRepo.save(mapper.toOrder(request));
        for (PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
              new OrderLineRequest(
                      null,
                      order.getId(),
                      purchaseRequest.productId(),
                      purchaseRequest.quantity()
              )
            );
        }
        paymentRestClient.requestOrderPayment(
                new PaymentRequest(
                        request.amount(),
                        request.paymentMethod(),
                        order.getId(),
                        order.getReference(),
                        customer
                )
        );
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepo.findAll()
                .stream()
                .map(mapper::fromOrder)
                .toList();
    }

    public OrderResponse findById(Integer id) {
        return orderRepo.findById(id).map(mapper::fromOrder)
                 .orElseThrow(()->
                         new EntityNotFoundException(String.format("No order found for the provided ID : %s",id)));
    }
}
