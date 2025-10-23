package org.ahmed.ecom.services;

import org.ahmed.ecom.dtos.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service",
        url = "${application.config.payment-url}"
)
public interface PaymentRestClient {
    @PostMapping
    Integer requestOrderPayment(@RequestBody PaymentRequest request);
}
