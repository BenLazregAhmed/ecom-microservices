package org.ahmed.ecom.product_service.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.product_service.dtos.ProductPurchaseRequest;
import org.ahmed.ecom.product_service.dtos.ProductPurchaseResponse;
import org.ahmed.ecom.product_service.dtos.ProductRequest;
import org.ahmed.ecom.product_service.dtos.ProductResponse;
import org.ahmed.ecom.product_service.exceptions.ProductNotFoundException;
import org.ahmed.ecom.product_service.exceptions.ProductPurchaseException;
import org.ahmed.ecom.product_service.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer>createProduct(
            @RequestBody@Valid ProductRequest request
    ){
        return ResponseEntity.ok(service.createProduct(request));
    }
    @PostMapping(path = "/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>purchaseProducts(
            @RequestBody List<ProductPurchaseRequest>request
    ) throws ProductPurchaseException {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }
    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductResponse>findById(
            @PathVariable Integer productId
    ) throws ProductNotFoundException {
        return ResponseEntity.ok(service.findById(productId));
    }
    @GetMapping
    public ResponseEntity<List<ProductPurchaseResponse>>findAll(
            @RequestBody List<ProductPurchaseRequest>request
    ) throws ProductPurchaseException {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }
}
