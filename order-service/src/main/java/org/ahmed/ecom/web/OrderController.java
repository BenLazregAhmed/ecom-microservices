package org.ahmed.ecom.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.OrderRequest;
import org.ahmed.ecom.dtos.OrderResponse;
import org.ahmed.ecom.exceptions.BusinessException;
import org.ahmed.ecom.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public ResponseEntity<Integer>createOrder(
            @RequestBody@Valid OrderRequest request
    ) throws BusinessException {
        return ResponseEntity.ok(service.createOrder(request));
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>>findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderResponse>findById(
            @PathVariable Integer orderId
    ){
        return ResponseEntity.ok(service.findById(orderId));
    }
}
