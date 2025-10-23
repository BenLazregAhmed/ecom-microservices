package org.ecom_ahmed.customer_service.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.ecom_ahmed.customer_service.entities.Address;

public record CustomerRequest(String id,
                              @NotNull(message = "customer first name is required")
                              String firstName,
                              @NotNull(message = "customer last name is required")

                              String lastName,
                              @Email(message = "customer email is invalid")
                              String email,
                              Address address
) {}

