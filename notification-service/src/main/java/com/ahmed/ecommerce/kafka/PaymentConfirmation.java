package com.ahmed.ecommerce.kafka;



import org.ahmed.ecom.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        String paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
