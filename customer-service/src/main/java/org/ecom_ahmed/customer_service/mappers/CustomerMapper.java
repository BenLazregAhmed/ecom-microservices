package org.ecom_ahmed.customer_service.mappers;

import org.ecom_ahmed.customer_service.entities.Customer;
import org.ecom_ahmed.customer_service.repositories.CustomerRepository;
import org.ecom_ahmed.customer_service.requests.CustomerRequest;
import org.ecom_ahmed.customer_service.responses.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        if (customerRequest==null)
            return null;
        return Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .address(customerRequest.address())
                .email(customerRequest.email())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
                );
    }
}
