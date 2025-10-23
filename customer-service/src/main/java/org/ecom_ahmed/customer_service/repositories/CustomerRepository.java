package org.ecom_ahmed.customer_service.repositories;

import org.ecom_ahmed.customer_service.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
