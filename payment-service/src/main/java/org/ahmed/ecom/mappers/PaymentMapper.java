package org.ahmed.ecom.mappers;

import org.ahmed.ecom.dtos.PaymentRequest;
import org.ahmed.ecom.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .orderId(request.OrderId())
                .build();
    }
}
