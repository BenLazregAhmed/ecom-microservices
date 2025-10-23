package org.ahmed.ecom.dtos;

public record CustomerResponse(
        String id,
        String firstName,
        String LastName,
        String email
) {
}
