package org.ecom_ahmed.customer_service.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.ecom_ahmed.customer_service.entities.Customer;
import org.ecom_ahmed.customer_service.exceptions.CustomerNotFoundException;
import org.ecom_ahmed.customer_service.mappers.CustomerMapper;
import org.ecom_ahmed.customer_service.repositories.CustomerRepository;
import org.ecom_ahmed.customer_service.requests.CustomerRequest;
import org.ecom_ahmed.customer_service.responses.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    public String createcustomer(CustomerRequest customerRequest) {
        var customer=customerRepository.save(mapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) throws CustomerNotFoundException {
        var customer = customerRepository.findById(request.id()).orElseThrow(
                ()->new CustomerNotFoundException(String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id()))
        );
        mergeCustomer(customer,request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstName()))
        {
            customer.setFirstName(request.firstName());
        }if(StringUtils.isNotBlank(request.lastName()))
        {
            customer.setLastName(request.lastName());
        }if(StringUtils.isNotBlank(request.email()))
        {
            customer.setEmail(request.email());
        }if(request.address()!=null)
        {
            customer.setAddress(request.address());
        }

    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll().stream().map(
                mapper::fromCustomer
        ).toList();
    }

    public Boolean existsById(String id) {
        return customerRepository.findById(id).isPresent();
    }

    public CustomerResponse findById(String id) throws CustomerNotFoundException {
        return customerRepository.findById(id).map(
                mapper::fromCustomer
        ).orElseThrow(()->new CustomerNotFoundException(
                String.format("No customer found with the provided ID: %s", id))
        );
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
