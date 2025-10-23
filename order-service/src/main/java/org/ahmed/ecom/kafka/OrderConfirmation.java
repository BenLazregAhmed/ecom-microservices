package org.ahmed.ecom.kafka;

import org.ahmed.ecom.dtos.CustomerResponse;
import org.ahmed.ecom.dtos.PurchaseResponse;
import org.ahmed.ecom.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse>products
) {
}
