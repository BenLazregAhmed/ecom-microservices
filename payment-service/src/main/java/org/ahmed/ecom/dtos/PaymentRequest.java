package org.ahmed.ecom.dtos;

import org.ahmed.ecom.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer OrderId,
        String orderReference,
        Customer customer
) {
}
