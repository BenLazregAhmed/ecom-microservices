package org.ahmed.ecom.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product id mandatory")
        Integer productId,
        @Positive(message = "quantity is mandatory")
        double quantity
) {
}
