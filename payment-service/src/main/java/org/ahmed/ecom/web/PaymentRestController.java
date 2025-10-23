package org.ahmed.ecom.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.PaymentRequest;
import org.ahmed.ecom.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/payments")
public class PaymentRestController {
    private final PaymentService service;

    @PostMapping
    public ResponseEntity<Integer>createPayment(
            @RequestBody@Valid PaymentRequest request
    ){
        return ResponseEntity.ok(service.createPayment(request));
    }
}
