package org.ahmed.ecom.product_service.dtos;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price
) {
}
