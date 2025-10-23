package org.ecom_ahmed.customer_service.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ecom_ahmed.customer_service.exceptions.CustomerNotFoundException;
import org.ecom_ahmed.customer_service.requests.CustomerRequest;
import org.ecom_ahmed.customer_service.responses.CustomerResponse;
import org.ecom_ahmed.customer_service.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody@Valid CustomerRequest customerRequest
    ){
        return ResponseEntity.ok(service.createcustomer(customerRequest));
    }
    @PutMapping
    public ResponseEntity<Void>updateCustomer(
            @RequestBody@Valid CustomerRequest request
    ) throws CustomerNotFoundException {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<CustomerResponse>>findAll(){
        return ResponseEntity.ok(service.findAllCustomers());
    }
    @GetMapping(path = "/exists/{customerId}")
    public ResponseEntity<Boolean>existsById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(service.existsById(id));
    }
    @GetMapping(path = "/{customerId}")
    public ResponseEntity<CustomerResponse>findById(
            @PathVariable(name ="customerId" ) String customerId
    ) throws CustomerNotFoundException {
        return ResponseEntity.ok(service.findById(customerId));
    }
    @DeleteMapping(path = "/{customerId}")
    public ResponseEntity<Void>deleteCustomer(
            @PathVariable String id
    ) throws CustomerNotFoundException {
        service.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }
}
