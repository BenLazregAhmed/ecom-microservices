package org.ahmed.ecom.product_service.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.ahmed.ecom.product_service.entities.Category;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "product name is required")
        String name,
        @NotNull(message = "product description is required")

        String description,
        @Positive(message = "Available Quantity should not be negative")
        double availableQuantity,
        @Positive(message = "Price should not be negative")

        BigDecimal price,
        @NotNull(message = "product category is required")

        Integer categoryId
) {
}
