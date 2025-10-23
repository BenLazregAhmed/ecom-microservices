package org.ahmed.ecom.web;

import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.OrderLineResponse;
import org.ahmed.ecom.services.OrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService service;

    @GetMapping(path = "/order/{orderId}")
    public ResponseEntity<List<OrderLineResponse>>findByOrderId(
            @PathVariable Integer orderId
            ){
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }
}
