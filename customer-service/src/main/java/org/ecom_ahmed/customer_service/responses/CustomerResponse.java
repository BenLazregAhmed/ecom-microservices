package org.ecom_ahmed.customer_service.responses;
import org.ecom_ahmed.customer_service.entities.Address;

public record CustomerResponse(
        String id,
        String firstName,

        String lastName,
        String email,
        Address address
) {
}
