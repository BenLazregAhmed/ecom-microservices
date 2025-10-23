package org.ahmed.ecom.dtos;

import org.ahmed.ecom.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer OrderId,
        String orderReference,
        CustomerResponse customer
) {
}
