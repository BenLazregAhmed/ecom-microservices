package com.ahmed.ecommerce.kafka;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
