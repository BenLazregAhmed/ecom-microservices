package org.ahmed.ecom.services;

import org.ahmed.ecom.dtos.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerRestClient {
    @GetMapping("/{customerId}")
    Optional<CustomerResponse>findCustomerById(@PathVariable(name = "customerId") String customerId);
}
