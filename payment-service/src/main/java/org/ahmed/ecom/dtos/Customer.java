package org.ahmed.ecom.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
//means that the attribute of type customer will be validated using the validation specified in here
@Validated
public record Customer(
    String id,
    @NotNull(message = "Firstname is required")
    String firstName,
    @NotNull(message = "Lastname is required")
    String LastName,
    @NotNull(message = "Email is required")
    @Email(message = "Customer email is not well formatted")
    String email
) {
}
